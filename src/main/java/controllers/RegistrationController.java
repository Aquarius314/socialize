package controllers;

import dao.DatabaseAdapter;
import domain.RegistrationForm;
import domain.RegistrationJsonResponse;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private DatabaseAdapter db;

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
        User user = User.fromRegistrationForm(form);
        if (db.users.registerUser(user)) {
            String messageOk = "User registered successfully";
            System.out.println(messageOk);
            response.setMessage(messageOk);
        } else {
            String messageError = "Something went wrong";
            System.out.println(messageError);
            response.setMessage(messageError);
        }
        return response;
    }

    private boolean validateUserRegistration(RegistrationForm form) {
        return db.auth.emailRegistered(form.getEmail());
    }
}
