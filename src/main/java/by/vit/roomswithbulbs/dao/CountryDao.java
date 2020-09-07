package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.entity.Country;

import java.util.List;

/**
 * Interface CountryDao.
 *
 * Provides access to the country storage.
 *
 * @author Vitaly Lobatsevich
 */
public interface CountryDao {

    /**
     * @return list of all countries.
     */
    List<Country> getAll();

}
