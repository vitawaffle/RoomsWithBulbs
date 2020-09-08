package by.vit.roomswithbulbs.dao;

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
    List<String> getAll();

}
