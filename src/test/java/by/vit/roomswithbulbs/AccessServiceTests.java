package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.repository.CountryRepository;
import by.vit.roomswithbulbs.repository.RoomRepository;
import by.vit.roomswithbulbs.service.AccessService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AccessServiceTests {

    @Autowired
    private AccessService accessService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CountryRepository countryRepository;

    private Room roomBy;

    private Room roomUs;

    private String addressBy = "88.202.105.48";

    @BeforeEach
    public void init() {
        final Country countryBy = countryRepository.save(new Country(null, "Belarus", "BY"));
        final Country countryUs = countryRepository.save(new Country(null, "United States", "US"));
        roomBy = roomRepository.save(new Room(null, "Room1", countryBy, false));
        roomUs = roomRepository.save(new Room(null, "Room2", countryUs, false));
    }

    @AfterEach
    public void clean() {
        countryRepository.deleteAll();
        roomRepository.deleteAll();
    }

    @Test
    public void checkByRoomId_ExistingRoomIdAndRightIp_ShouldReturnTrue() {
        assertTrue(accessService.checkByRoomId(roomBy.getId(), addressBy));
    }

    @Test
    public void checkByRoomId_ExistingRoomIdAndNotRightIp_ShouldReturnFalse() {
        assertFalse(accessService.checkByRoomId(roomUs.getId(), addressBy));
    }

    @Test
    public void checkByRoomId_NotExistingRoomId_ShouldReturnTrue() {
        assertTrue(accessService.checkByRoomId("", addressBy));
    }

}
