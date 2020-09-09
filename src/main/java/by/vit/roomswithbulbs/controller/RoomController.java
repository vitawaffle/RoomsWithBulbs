package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.exception.ForbiddenException;
import by.vit.roomswithbulbs.service.LocationService;
import by.vit.roomswithbulbs.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    /** Location service. */
    private final LocationService locationService;

    /**
     * Constructor.
     *
     * @param roomService - room service.
     * @param locationService - location service.
     */
    @Autowired
    public RoomController(final RoomService roomService, final LocationService locationService) {
        this.roomService = roomService;
        this.locationService = locationService;
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
     * Returns room by id.
     *
     * @param id - room id.
     * @param request - request.
     * @return room entity or null
     */
    @GetMapping("/{id}")
    public Room getByName(@PathVariable final String id, final HttpServletRequest request) {
        final Room room = roomService.getById(id);
        if (room == null)
            return null;
        if (!locationService.getCountryNameByIp(request.getRemoteAddr()).equals(room.getCountry().getName()))
            throw new ForbiddenException();
        return room;
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
