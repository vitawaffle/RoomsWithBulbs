package by.vit.roomswithbulbs.service;

import javax.servlet.http.HttpServletRequest;

/**
 * This service checks if the user has access to the room.
 *
 * @author Vitaly Lobatsevich
 */
public interface AccessService {

    /**
     * Checks if the user has access to the room.
     *
     * @param id - room id.
     * @param request - request from client.
     * @return true if has and false otherwise.
     */
    boolean check(String id, HttpServletRequest request);

}
