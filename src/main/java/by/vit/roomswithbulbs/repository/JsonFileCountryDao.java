package by.vit.roomswithbulbs.repository;

import by.vit.roomswithbulbs.entity.Country;

import java.util.List;

/**
 * Provides access to the country storage in json file.
 *
 * @author Vitaly Lobatsevich
 */
public interface JsonFileCountryDao {

    /**
     * @return list of all countries.
     */
    List<Country> findAll();

}
