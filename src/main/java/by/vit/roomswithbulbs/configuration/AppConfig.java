package by.vit.roomswithbulbs.configuration;

import by.vit.roomswithbulbs.repository.JsonFileCountryDao;
import by.vit.roomswithbulbs.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Default application configuration class.
 *
 * @author Vitaly Lobatsevich
 */
@Configuration
public class AppConfig {

    /** Country repository. */
    private final CountryRepository countryRepository;

    /** Json file country DAO. */
    private final JsonFileCountryDao jsonFileCountryDao;

    /**
     * Constructor.
     *
     * @param countryRepository - country repository.
     * @param jsonFileCountryDao - json file country DAO.
     */
    @Autowired
    public AppConfig(final CountryRepository countryRepository, final JsonFileCountryDao jsonFileCountryDao) {
        this.countryRepository = countryRepository;
        this.jsonFileCountryDao = jsonFileCountryDao;
    }

    /**
     * This method initialize country repository by loading data from json file.
     */
    @Bean
    public void initializeDefaultCountries() {
        if (countryRepository.findAll().isEmpty()) {
            jsonFileCountryDao.findAll().forEach(countryRepository::save);
        }
    }

}
