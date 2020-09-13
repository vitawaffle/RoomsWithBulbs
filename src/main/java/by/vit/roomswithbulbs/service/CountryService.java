package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.entity.Country;

import java.util.List;

/**
 * Country service.
 *
 * @author Vitaly Lobatsevich
 */
public interface CountryService extends AppService<Country, String> {

    /**
     * Returns all countries.
     *
     * @return list of all countries.
     */
    List<Country> getAll();

}
