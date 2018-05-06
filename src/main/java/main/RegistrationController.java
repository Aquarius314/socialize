package main;

import dao.DatabaseAdapter;
import domain.RegistrationForm;
import domain.RegistrationJsonResponse;
import domain.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jakub on 05.05.18.
 */

@Controller
public class RegistrationController {

    @GetMapping("/")
    public String registrationPage() {
        return "register/registration-page";
    }

    @PostMapping(value = "/register-new-user", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public RegistrationJsonResponse registerUser(@ModelAttribute RegistrationForm form) {
        System.out.println("Received form: ");
        System.out.println(form.getEmail() + ", " + form.getPassword());
        RegistrationJsonResponse response = new RegistrationJsonResponse();
        response.setValidated(validateUserRegistration(form));
        User user = new User();
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        if (DatabaseAdapter.registerUser(user)) {
            System.out.println("User registered successfully");
            response.setMessage("User registered successfully");
        } else {
            System.out.println("Something went wrong");
            response.setMessage("Something went wrong");
        }
        return response;
    }

    private boolean validateUserRegistration(RegistrationForm form) {
        return DatabaseAdapter.emailRegistered(form.getEmail());
    }
}
