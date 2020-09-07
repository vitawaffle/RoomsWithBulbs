package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.dao.CountryDao;
import by.vit.roomswithbulbs.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryDao countryDao;

    @Autowired
    public CountryController(final CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @GetMapping
    public List<Country> getAll() {
        return countryDao.getAll();
    }

}
