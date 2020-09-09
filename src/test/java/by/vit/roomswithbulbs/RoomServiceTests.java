package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.dao.CountryDao;
import by.vit.roomswithbulbs.dao.RoomDao;
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
    private RoomDao roomDao;

    @Autowired
    private CountryDao countryDao;

    private String id;

    @BeforeEach
    public void init() {
        final Room room = new Room(null, "Room1", countryDao.findAll().get(0));
        id = roomDao.save(room).getId();
    }

    @AfterEach
    public void clean() {
        roomDao.deleteAll();
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
        final Room room = new Room(null, "Room2", countryDao.findAll().get(0));
        assertDoesNotThrow(() -> roomService.save(room));
    }

    @Test
    public void deleteById_ExistingId_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> roomService.deleteById(id));
    }

    @Test
    public void deleteById_NotExistingId_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> roomService.deleteById(""));
    }

}
