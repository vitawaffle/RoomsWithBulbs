package by.vit.roomswithbulbs.controller;

import by.vit.roomswithbulbs.entity.Room;
import by.vit.roomswithbulbs.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Light controller.
 *
 * @author Vitaly Lobatsevich
 */
@Controller
public class LightController {

    /** Room service. */
    private final RoomService roomService;

    /**
     * Constructor.
     *
     * @param roomService - room service.
     */
    @Autowired
    public LightController(final RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * Subscribe to room topic. Switch light.
     *
     * @param id - room id.
     * @return light switched room.
     * @throws Exception
     */
    @MessageMapping("/switchLight/{id}")
    @SendTo("/topic/room/{id}")
    public Room switchLight(@DestinationVariable final String id) throws Exception {
        return roomService.switchLightAndGetById(id);
    }

}
