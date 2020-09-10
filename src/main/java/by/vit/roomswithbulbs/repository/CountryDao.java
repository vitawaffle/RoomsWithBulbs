package by.vit.roomswithbulbs.repository;

import by.vit.roomswithbulbs.entity.Country;

import java.util.List;

/**
 * Provides access to the country storage.
 *
 * @author Vitaly Lobatsevich
 */
public interface CountryDao {

    /**
     * @return list of all countries.
     */
    List<Country> findAll();

}
