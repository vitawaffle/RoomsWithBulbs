package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.entity.Room;

import java.util.List;

/**
 * Interface RoomDao.
 *
 * Provides access to room storage.
 *
 * @author Vitaly Lobatsevich
 */
public interface RoomDao {

    /**
     * @return list of all rooms.
     */
    List<Room> getAll();

    /**
     * Creates new room.
     *
     * @param room - room to create.
     */
    void create(Room room);

    /**
     * Deletes all rooms in storage.
     */
    void deleteAll();

}
