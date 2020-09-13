package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.repository.CountryRepository;
import by.vit.roomswithbulbs.repository.RoomRepository;
import by.vit.roomswithbulbs.service.LocationService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LightControllerTests {

    private final static Logger log = Logger.getLogger(LightControllerTests.class.getName());

    @LocalServerPort
    private Integer port;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LocationService locationService;

    private Country serverCountry;
    private Country anotherCountry;
    private Room room1;
    private Room room2;

    private WebSocketStompClient client;

    private CompletableFuture<Room> roomCompletableFuture;

    @BeforeEach
    public void init() {
        final String countryCode = locationService.getCountryCodeByIp("127.0.0.1");
        final String countryName = locationService.getCountryNameByIp("127.0.0.1");
        serverCountry = countryRepository.save(new Country(null, countryName, countryCode));
        if (countryCode.equals("BY")) {
            anotherCountry = countryRepository.save(new Country(null, "United States", "US"));
        } else {
            anotherCountry = countryRepository.save(new Country(null, "Belarus", "BY"));
        }

        room1 = roomRepository.save(new Room(null, "Room 1", serverCountry, false));
        room2 = roomRepository.save(new Room(null, "Room 2", anotherCountry, false));

        log.log(Level.INFO, "Server country: " + serverCountry.getAlpha2());
        log.log(Level.INFO, "Another country: " + anotherCountry.getAlpha2());

        client = new WebSocketStompClient(new SockJsClient(List.of(new WebSocketTransport(
                new StandardWebSocketClient()))));
        client.setMessageConverter(new MappingJackson2MessageConverter());

        roomCompletableFuture = new CompletableFuture<>();
    }

    @AfterEach
    public void clean() {
        roomRepository.deleteAll();
        countryRepository.deleteAll();
    }

    @Test
    public void connect_ShouldConnect() {
        assertDoesNotThrow(() -> {
            final StompSession session = client.connect(String.format("ws://localhost:%d/rooms-with-bulbs", port),
                    new StompSessionHandlerAdapter() {}).get(1, TimeUnit.SECONDS);
        });
    }

    @Test
    public void subscribe_ClientAndRoomCountriesMatch_ShouldDoesNotThrow() throws Exception {
        final StompSession session = client.connect(String.format("ws://localhost:%d/rooms-with-bulbs", port),
                new StompSessionHandlerAdapter() {}).get(1, TimeUnit.SECONDS);
        assertDoesNotThrow(() -> {
            session.subscribe("/topic/room/" + room1.getId(), new SwitchLightHandler());
            session.send("/app/switchLight/" + room1.getId(), null);
            final Room room = roomCompletableFuture.get(10, TimeUnit.SECONDS);
            log.log(Level.INFO, "Light: " + room.getLight());
        });
    }

    @Test
    public void subscribe_ClientAndRoomCountriesDoNotMatch_ShouldThrowsException() throws Exception {
        final StompSession session = client.connect(String.format("ws://localhost:%d/rooms-with-bulbs", port),
                new StompSessionHandlerAdapter() {}).get(1, TimeUnit.SECONDS);
        assertThrows(Exception.class, () -> {
            session.subscribe("/topic/room/" + room2.getId(), new SwitchLightHandler());
            session.send("/app/switchLight/" + room2.getId(), new SwitchLightHandler());
            final Room room = roomCompletableFuture.get(10, TimeUnit.SECONDS);
            log.log(Level.INFO, "Light: " + room.getLight());
        });
    }

    private class SwitchLightHandler implements StompFrameHandler {

        @Override
        public Type getPayloadType(final StompHeaders stompHeaders) {
            return Room.class;
        }

        @Override
        public void handleFrame(final StompHeaders stompHeaders, final Object o) {
            roomCompletableFuture.complete((Room) o);
        }

    }

}
