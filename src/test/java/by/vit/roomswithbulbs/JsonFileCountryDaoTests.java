package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.repository.JsonFileCountryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JsonFileCountryDaoTests {

    @Autowired
    private JsonFileCountryDao jsonFileCountryDao;

    @Test
    public void findAll_ShouldReturnNotEmpty() {
        assertFalse(jsonFileCountryDao.findAll().isEmpty());
    }

}
