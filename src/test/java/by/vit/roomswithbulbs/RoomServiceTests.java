package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.repository.JsonFileCountryDao;
import by.vit.roomswithbulbs.repository.RoomRepository;
import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.service.RoomService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomServiceTests {

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private JsonFileCountryDao countryDao;

    private String id;

    @BeforeEach
    public void init() {
        final Room room = new Room(null, "Room1", countryDao.findAll().get(0), false);
        id = roomRepository.save(room).getId();
    }

    @AfterEach
    public void clean() {
        roomRepository.deleteAll();
    }

    @Test
    public void getAll_ShouldReturnNotEmpty() {
        assertFalse(roomService.getAll().isEmpty());
    }

    @Test
    public void getById_ExistingId_ShouldReturnNotNull() {
        assertNotNull(roomService.getById(id));
    }

    @Test
    public void getById_NotExistingId_ShouldReturnNull() {
        assertNull(roomService.getById(""));
    }

    @Test
    public void save_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> {
            roomService.save(new Room(null, "Room2", countryDao.findAll().get(0), false));
        });
    }

    @Test
    public void deleteById_ExistingId_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> {
            roomService.deleteById(id);
        });
    }

    @Test
    public void deleteById_NotExistingId_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> {
            roomService.deleteById("");
        });
    }

}
