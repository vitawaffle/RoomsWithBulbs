package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.entity.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class JsonFileCountryDao.
 *
 * Provides access to countries in a json file.
 *
 * @author Vitaly Lobatsevich
 */
@Repository
public class JsonFileCountryDao implements CountryDao {

    /** Logger. */
    private static final Logger log = Logger.getLogger(JsonFileCountryDao.class.getName());

    /** Object mapper. */
    private final ObjectMapper mapper;

    /** Json file with countries. */
    @Value("classpath:countries.json")
    private Resource jsonFile;

    /**
     * Constructor.
     *
     * @param mapper = object mapper.
     */
    @Autowired
    private JsonFileCountryDao(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Country> getAll() {
        try {
            return Arrays.asList(mapper.readValue(jsonFile.getFile(), Country[].class));
        } catch (IOException exception) {
            log.log(Level.SEVERE, "Error of reading \"countries.json\" file: ", exception);
            return Collections.emptyList();
        }
    }

}
