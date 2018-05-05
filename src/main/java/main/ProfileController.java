package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jakub on 05.05.18.
 */
@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String profilePage() {
        return "profile-page.html";
    }
}
