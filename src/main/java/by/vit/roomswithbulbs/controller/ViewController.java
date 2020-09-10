package by.vit.roomswithbulbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This class controls the views.
 *
 * @author Vitaly Lobatsevich
 */
@Controller
public class ViewController {

    /**
     * Index view.
     *
     * @return view name.
     */
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    /**
     * Room view.
     *
     * @param id - room id.
     * @return view name.
     */
    @GetMapping("/room")
    public String room(@RequestParam final String id) {
        return "room.html";
    }

}
