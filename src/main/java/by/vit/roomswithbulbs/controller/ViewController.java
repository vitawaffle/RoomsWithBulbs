package by.vit.roomswithbulbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class controls the views.
 *
 * @author Vitaly Lobatsevich
 */
@Controller
public class ViewController {

    /** Logger. */
    private static final Logger log = Logger.getLogger(ViewController.class.getName());

    /**
     * Index view.
     *
     * @return view name.
     */
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/room")
    public String room(@RequestParam final String name, final HttpServletRequest request) {
        return "room.html";
    }

}
