package main;

import dao.PersonDao;
import domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * Created by jakub on 05.05.18.
 */
@Controller
public class ProfileController {

    @RequestMapping("/profile/{id}")
    public String profilePage(Model model, @PathVariable(name="id") String id) {
        Optional<Person> person = PersonDao.getById(id);
        if (person.isPresent()) {
            model.addAttribute("person", person.get());
        } else {
            return "redirect:/error";
        }
        return "profile/profile-page";
    }
}
