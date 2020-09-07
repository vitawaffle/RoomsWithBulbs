package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.dao.CountryDao;
import by.vit.roomswithbulbs.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class controls country entities.
 *
 * @author Vitaly Lobatsevich
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    /** Country dao. */
    private final CountryDao countryDao;

    /**
     * Constructor.
     *
     * @param countryDao - country dao.
     */
    @Autowired
    public CountryController(final CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    /**
     * Returns all countries.
     *
     * @return list of countries.
     */
    @GetMapping
    public List<Country> getAll() {
        return countryDao.getAll();
    }

}
