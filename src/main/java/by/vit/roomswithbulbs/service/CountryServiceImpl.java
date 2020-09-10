package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.entity.Country;
import by.vit.roomswithbulbs.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Country service implementation.
 *
 * @author Vitaly Lobatsevich
 */
@Service
public class CountryServiceImpl implements CountryService {

    /** Country repository. */
    private final CountryRepository countryRepository;

    /**
     * Constructor.
     *
     * @param countryRepository - country repository.
     */
    @Autowired
    public CountryServiceImpl(final CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(final String id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public String save(final Country country) {
        return countryRepository.save(country).getId();
    }

    @Override
    public void deleteById(final String id) {
        countryRepository.deleteById(id);
    }

}
