package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.exception.NotUniqueValueException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class ListRoomDao.
 *
 * Provides access to countries in a java list.
 *
 * @author Vitaly Lobatsevich
 */
@Repository
public class ListRoomDao implements RoomDao {

    /** List of all rooms. */
    private final List<Room> rooms;

    /** Default constructor. */
    public ListRoomDao() {
        rooms = new ArrayList<>();
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }

    @Override
    public void create(final Room room) {
        rooms.forEach(el -> {
            if (el.getName().equals(room.getName()))
                throw new NotUniqueValueException("The name must be unique.");
        });
        rooms.add(room);
    }

    @Override
    public void deleteAll() {
        rooms.clear();
    }

}
