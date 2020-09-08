package by.vit.roomswithbulbs.service;

import by.vit.roomswithbulbs.dao.RoomDao;
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

    /** Room DAO. */
    private final RoomDao roomDao;

    /**
     * Constructor.
     *
     * @param roomDao - room DAO.
     */
    @Autowired
    public RoomServiceImpl(final RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    @Override
    public List<Room> getAll() {
        return roomDao.findAll();
    }

    @Override
    public Room getById(final String id) {
        return roomDao.findById(id).orElse(null);
    }

    @Override
    public String save(final Room room) {
        return roomDao.save(room).getId();
    }

    @Override
    public void deleteById(final String id) {
        roomDao.deleteById(id);
    }

}
