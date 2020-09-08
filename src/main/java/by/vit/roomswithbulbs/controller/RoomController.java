package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.service.RoomService;
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

    /** Room service. */
    private final RoomService roomService;

    /**
     * Constructor.
     *
     * @param roomService - room service.
     */
    @Autowired
    public RoomController(final RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Returns all rooms.
     *
     * @return list of all rooms.
     */
    @GetMapping
    public List<Room> getAll() {
        return roomService.getAll();
    }

    /**
     * Saves room.
     *
     * @param room - room to save.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody final Room room) {
        roomService.save(room);
    }

}
