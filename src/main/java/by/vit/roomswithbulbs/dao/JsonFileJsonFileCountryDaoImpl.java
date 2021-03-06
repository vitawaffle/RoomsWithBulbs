package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.dao.JsonFileCountryDao;
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

/**
 * Json file country DAO implementation.
 *
 * @author Vitaly Lobatsevich
 */
@Repository
public class JsonFileJsonFileCountryDaoImpl implements JsonFileCountryDao {

    /** Json file with countries. */
    @Value("classpath:countries.json")
    private Resource jsonFile;

    /** Object mapper. */
    private final ObjectMapper mapper;

    /** List of all countries. */
    private List<Country> countries;

    /**
     * Constructor.
     *
     * @param mapper - object mapper.
     */
    @Autowired
    public JsonFileJsonFileCountryDaoImpl(final ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Country> findAll() {
        if (countries == null) {
            try {
                countries = Arrays.asList(mapper.readValue(jsonFile.getFile(), Country[].class));
            } catch (IOException exception) {
                countries = Collections.emptyList();
            }
        }
        return countries;
    }

}
