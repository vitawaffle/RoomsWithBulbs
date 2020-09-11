package by.vit.roomswithbulbs.service;

import javax.servlet.http.HttpServletRequest;

/**
 * This service checks client access.
 *
 * @author Vitaly Lobatsevich
 */
public interface AccessService {

    /**
     * Checks if the client with specified IP has access to the room with specified id.
     *
     * @param id - room id.
     * @param ip - client ip.
     * @return true if has and false otherwise.
     */
    Boolean checkByRoomId(String id, String ip);

}
