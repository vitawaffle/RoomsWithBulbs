package by.vit.roomswithbulbs.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * LocationService implementation that used ipstack service to determine location.
 *
 * @author Vitaly Lobatsevich
 */
@Service
public class IpStackClientLocation implements LocationService {

    /** Rest template. */
    private final RestTemplate restTemplate;

    /** Access key for ipstack service. */
    @Value("${ipstack.access_key}")
    private String accessKey;

    /**
     * Constructor.
     */
    public IpStackClientLocation() {
        restTemplate = new RestTemplate();
    }

    @Override
    public String getCountryName() {
        final Country country = restTemplate.getForObject(
                "http://api.ipstack.com/check?access_key=" + accessKey,
                    Country.class
                );
        return country != null ? country.country_name : null;
    }

    private static class Country {
        public String country_name;
    }

}
