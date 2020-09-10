package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.repository.CountryRepository;
import by.vit.roomswithbulbs.service.CountryService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CountryServiceTests {

    @Autowired
    private CountryService countryService;

    @Autowired
    CountryRepository countryRepository;

    private String id;

    @BeforeEach
    public void init() {
        id = countryRepository.save(new Country(null, "Belarus")).getId();
    }

    @AfterEach
    public void clean() {
        countryRepository.deleteAll();
    }

    @Test
    public void getAll_ShouldReturnNotEmpty() {
        assertFalse(countryService.getAll().isEmpty());
    }

    @Test
    public void getById_ExistingId_ShouldReturnNotNull() {
        assertNotNull(countryService.getById(id));
    }

    @Test
    public void getById_NotExistingId_ShouldReturnNull() {
        assertNull(countryService.getById(""));
    }

    @Test
    public void save_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> {
            countryService.save(new Country(null, "Russia"));
        });
    }

    @Test
    public void deleteById_ExistingId_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> {
            countryService.deleteById(id);
        });
    }

    @Test
    public void deleteById_NotExistingId_ShouldDoesNotThrow() {
        assertDoesNotThrow(() -> {
            countryService.deleteById("");
        });
    }

}
