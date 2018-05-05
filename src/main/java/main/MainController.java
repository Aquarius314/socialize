package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jakub on 05.05.18.
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String mainPage() {
        return "main-page.html";
    }
}
