package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.dao.CountryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class CountryDaoTests {

    @Autowired
    private CountryDao countryDao;

    @Test
    public void getAll_ShouldReturnNotEmpty() {
        assertFalse(countryDao.getAll().isEmpty());
    }

}
