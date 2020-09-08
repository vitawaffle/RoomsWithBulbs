package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.dao.RoomDao;
import by.vit.roomswithbulbs.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class controls room logic.
 *
 * @author Vitaly Lobatsevich
 */
@RestController
@RequestMapping("/rooms")
public class RoomController {

    /** Room DAO. */
    private final RoomDao roomDao;

    /**
     * Constructor.
     *
     * @param roomDao - room DAO.
     */
    @Autowired
    public RoomController(final RoomDao roomDao) {
        this.roomDao = roomDao;
    }

    /**
     * Returns all rooms.
     *
     * @return list of all rooms.
     */
    @GetMapping
    public List<Room> getAll() {
        return roomDao.getAll();
    }

    /**
     * Creates new room.
     *
     * @param room - room to create.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final Room room) {
        roomDao.create(room);
    }

}
