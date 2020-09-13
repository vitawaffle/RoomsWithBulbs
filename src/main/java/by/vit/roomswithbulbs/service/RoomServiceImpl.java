package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.repository.RoomRepository;
import by.vit.roomswithbulbs.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Room service implementation.
 *
 * @author Vitaly Lobatsevich
 */
@Service
public class RoomServiceImpl implements RoomService {

    /** Room repository. */
    private final RoomRepository roomRepository;

    /**
     * Constructor.
     *
     * @param roomRepository - room repository.
     */
    @Autowired
    public RoomServiceImpl(final RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room switchLightAndGetById(final String id) {
        final Room room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            return null;
        }
        room.setLight(!room.getLight());
        return roomRepository.save(room);
    }

    @Override
    public Room getById(final String id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public String save(final Room room) {
        return roomRepository.save(room).getId();
    }

    @Override
    public void deleteById(final String id) {
        roomRepository.deleteById(id);
    }

}
