package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.dao.CountryDao;
import by.vit.roomswithbulbs.dao.RoomDao;
import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.exception.NotUniqueValueException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomDaoTests {

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private CountryDao countryDao;

    @BeforeEach
    public void init() {
        final Room room = new Room("Room1", countryDao.getAll().get(0));
        roomDao.create(room);
    }

    @AfterEach
    public void clean() {
        roomDao.deleteAll();
    }

    @Test
    public void getAll_ShouldReturnNotEmpty() {
        assertFalse(roomDao.getAll().isEmpty());
    }

    @Test
    public void create_Valid_ShouldDoesNotThrow() {
        final Room room = new Room("Room2", countryDao.getAll().get(0));
        assertDoesNotThrow(() -> {
            roomDao.create(room);
        });
    }

    @Test
    public void create_NotUniqueName_ShouldThrowsNotUniqueValueException() {
        final Room room = new Room("Room1", countryDao.getAll().get(0));
        assertThrows(NotUniqueValueException.class, () -> {
            roomDao.create(room);
        });
    }

}
