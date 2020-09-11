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
    public String getCountryNameByIp(final String ip) {
        String urlFormat = "http://api.ipstack.com/%s?access_key=%s&fields=country_name";
        String url;
        if (ip.equals("127.0.0.1")) {
            url = String.format(urlFormat, "check", accessKey);
        } else {
            url = String.format(urlFormat, ip, accessKey);
        }
        final CountryName country = restTemplate.getForObject(url, CountryName.class);
        return country != null ? country.country_name : null;
    }

    @Override
    public String getCountryCodeByIp(final String ip) {
        String urlFormat = "http://api.ipstack.com/%s?access_key=%s&fields=country_code";
        String url;
        if (ip.equals("127.0.0.1")) {
            url = String.format(urlFormat, "check", accessKey);
        } else {
            url = String.format(urlFormat, ip, accessKey);
        }
        final CountryCode countryCode = restTemplate.getForObject(url, CountryCode.class);
        return countryCode != null ? countryCode.country_code : null;
    }

    private static class CountryName {
        public String country_name;
    }

    private static class CountryCode {
        public String country_code;
    }

}
