package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.entity.Room;

import java.util.List;

/**
 * Room service.
 *
 * @author Vitaly Lobatsevich
 */
public interface RoomService extends AppService<Room, String> {

    /**
     * Returns all rooms.
     *
     * @return list of rooms.
     */
    List<Room> getAll();

    /**
     * Switches light in the room and gets by id.
     *
     * @param id - room id.
     * @return room entity or null.
     */
    Room switchLightAndGetById(String id);

}
