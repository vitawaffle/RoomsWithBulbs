package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Country controller.
 *
 * @author Vitaly Lobatsevich
 */
@RestController
@RequestMapping("/countries")
public class CountryController {

    /** Country service. */
    private final CountryService countryService;

    /**
     * Constructor.
     *
     * @param countryService - country service.
     */
    @Autowired
    public CountryController(final CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Returns all countries.
     *
     * @return list of countries.
     */
    @GetMapping
    public List<Country> getAll() {
        return countryService.getAll();
    }

    /**
     * Returns country by id.
     *
     * @param id - country id.
     * @return country entity or null.
     */
    @GetMapping("/{id}")
    public Country getById(@PathVariable final String id) {
        return countryService.getById(id);
    }

}
