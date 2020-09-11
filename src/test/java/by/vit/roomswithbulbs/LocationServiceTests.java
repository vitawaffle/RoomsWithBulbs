package by.vit.roomswithbulbs;

import by.vit.roomswithbulbs.service.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LocationServiceTests {

    @Autowired
    private LocationService locationService;

    @Test
    public void getCountryNameById_ShouldReturnBelarus() {
        assertEquals("United States", locationService.getCountryNameByIp("134.201.250.155"));
    }

    @Test
    public void getCountryCodeByIp_ShouldReturnUS() {
        assertEquals("US", locationService.getCountryCodeByIp("134.201.250.155"));
    }

}
