package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginPage(Model model) {
        return "login/login-page";
    }

    @RequestMapping("/logout")
    public String logoutPage(Model model) {
        System.out.println("Logged out");
        return "login/login-page";
    }

}
