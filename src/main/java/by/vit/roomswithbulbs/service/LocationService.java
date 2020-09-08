package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.entity.Country;

/**
 * Interface LocationService.
 *
 * Used for determine client location by ip.
 *
 * @author Vitaly Lobatsevich
 */
public interface LocationService {

    /**
     * Returns country by ip.
     *
     * @param ip - client ip.
     * @return country entity for this ip.
     */
    Country getCountryByIp(String ip);

}
