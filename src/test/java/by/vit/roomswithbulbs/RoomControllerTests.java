package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.repository.CountryRepository;
import by.vit.roomswithbulbs.repository.RoomRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class RoomControllerTests {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RoomRepository roomRepository;

    private Country country;

    private String id;

    @BeforeEach
    public void init(final WebApplicationContext context) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        country = countryRepository.save(new Country(null, "Belarus", "BY"));
        id = roomRepository.save(new Room(null, "Room1", country, false)).getId();
    }

    @AfterEach
    public void clean() {
        roomRepository.deleteAll();
        countryRepository.deleteAll();;
    }

    @Test
    public void getAll_ShouldReturnOkStatus() throws Exception {
        mockMvc.perform(get("/rooms").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAll_ShouldReturnNotEmpty() throws Exception {
        mockMvc.perform(get("/rooms").accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            assertTrue(mapper.readValue(result.getResponse().getContentAsString(), Room[].class).length > 0);
        });
    }

    @Test
    public void getById_ShouldReturnOkStatus() throws Exception {
        mockMvc.perform(get("/rooms/" + id).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getById_ExistingId_ShouldReturnNotNull() throws Exception {
        mockMvc.perform(get("/rooms/" + id).accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            assertNotNull(mapper.readValue(result.getResponse().getContentAsString(), Room.class));
        });
    }

    @Test
    public void getById_NotExistingId_ShouldReturnEmpty() throws Exception {
        mockMvc.perform(get("/rooms/noId").accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            assertTrue(result.getResponse().getContentAsString().isBlank());
        });
    }

    @Test
    public void getById_Room1Id_ShouldReturnRoom1() throws Exception {
        final Room room1 = roomRepository.findById(id).get();
        mockMvc.perform(get("/rooms/" + id).accept(MediaType.APPLICATION_JSON)).andDo(result -> {
            final Room room = mapper.readValue(result.getResponse().getContentAsString(), Room.class);
            assertTrue(room.getId().equals(room1.getId())
                    && room.getName().equals(room1.getName())
                    && room.getCountry().getAlpha2().equals(room1.getCountry().getAlpha2())
                    && room.getLight() == room1.getLight());
        });
    }

    @Test
    public void save_ShouldReturnCreatedStatus() throws Exception {
        mockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Room(null, "Room2", country, false)))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    public void save_ShouldReturnId() throws Exception {
        mockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Room(null, "Room2", country, false)))
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(result -> {
            assertTrue(result.getResponse().getContentAsString().isBlank());
        });
    }

    @Test
    public void save_ShouldSaveInDatabase() throws Exception {
        mockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Room(null, "Room2", country, false)))
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(result -> {
            assertNotNull(roomRepository.findByName("Room2"));
        });
    }

}
