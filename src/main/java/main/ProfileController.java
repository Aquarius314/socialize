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
        System.out.println("Okej dostałem takie id: " + id);
        if (id.equals("all")) {
            return allProfiles(model);
        }
        try {
            ApiFuture<DocumentSnapshot> futureDoc = DatabaseAdapter.getFutureUserById(id);
            DocumentSnapshot documentSnapshot = futureDoc.get();
            if (documentSnapshot.exists()) {
                User user = documentSnapshot.toObject(User.class);
                if (user != null) {
                    model.addAttribute("user", user);
                    System.out.println("Udało się!");
                } else {
                    System.out.println("User był nullem");
                }
            } else {
                System.out.println("Dokument nie istniał");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "profile/profile-page";
    }

    private String allProfiles(Model model) {
        try {
            ApiFuture<QuerySnapshot> futureQuery = DatabaseAdapter.getFutureAllUsers();
            List<QueryDocumentSnapshot> querySnapshot = futureQuery.get().getDocuments();
            if (!querySnapshot.isEmpty()) {
                List<User> allUsers = new LinkedList<>();
                for (DocumentSnapshot doc : querySnapshot) {
                    User user = doc.toObject(User.class);
                    allUsers.add(user);
                    System.out.println("Znaleziony user: " + user.getName() + " " + user.getSurname());
                }
                model.addAttribute("profiles", allUsers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "profile/all-profiles";
    }
}
