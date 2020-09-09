package by.vit.roomswithbulbs.service;

/**
 * Used for determine client location by ip.
 *
 * @author Vitaly Lobatsevich
 */
public interface LocationService {

    /**
     * Returns country by ip.
     *
     * @return country name for this ip.
     */
    String getCountryName();

}
