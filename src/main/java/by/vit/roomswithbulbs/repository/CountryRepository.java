package by.vit.roomswithbulbs.repository;

import by.vit.roomswithbulbs.entity.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides access to country storage.
 *
 * @author Vitaly Lobatsevich
 */
@Repository
public interface CountryRepository extends MongoRepository<Country, String> {

    /**
     * Finds country by name.
     *
     * @param name - country name.
     * @return country or null.
     */
    Country findByName(String name);

}
