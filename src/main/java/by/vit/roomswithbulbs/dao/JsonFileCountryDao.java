package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.entity.Country;

import java.util.List;

/**
 * Provides access to the country storage in json file.
 *
 * @author Vitaly Lobatsevich
 */
public interface JsonFileCountryDao {

    /**
     * Finds all countries.
     *
     * @return list of countries.
     */
    List<Country> findAll();

}
