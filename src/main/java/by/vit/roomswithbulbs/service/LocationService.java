package by.vit.roomswithbulbs.service;

/**
 * Used for determine client location by ip.
 *
 * @author Vitaly Lobatsevich
 */
public interface LocationService {

    /**
     * Returns country by client ip.
     *
     * @param ip - client ip.
     * @return country name for this ip.
     */
    String getCountryNameByIp(String ip);

}
