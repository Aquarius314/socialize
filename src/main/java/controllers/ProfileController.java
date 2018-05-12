package controllers;

import dao.DatabaseAdapter;
import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by jakub on 05.05.18.
 */
@Controller
public class ProfileController {

    @RequestMapping("/profile/{id}")
    public String profilePage(Model model, @PathVariable(name="id") String id) {
        Optional<User> user = DatabaseAdapter.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        } else {
            model.addAttribute("user", new User());
        }
        return "profile/profile-page";
    }

    @RequestMapping("/all-profiles")
    public String allProfiles(Model model) {
        List<User> allUsers = DatabaseAdapter.getAllUsers();
        model.addAttribute("users", allUsers);
        return "profile/all-profiles";
    }
}
