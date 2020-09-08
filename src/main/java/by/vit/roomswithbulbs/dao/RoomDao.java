package by.vit.roomswithbulbs.dao;

import by.vit.roomswithbulbs.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides access to room storage.
 *
 * @author Vitaly Lobatsevich
 */
@Repository
public interface RoomDao extends MongoRepository<Room, String> {

    /**
     * Finds room by name.
     *
     * @param name - room name.
     * @return room or null.
     */
    Room findByName(String name);

}
