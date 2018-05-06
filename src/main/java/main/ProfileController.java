package main;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import dao.DatabaseAdapter;
import dao.UserDao;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

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
