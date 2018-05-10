package controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jakub on 05.05.18.
 */
@Controller
public class NotFoundController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "errors/notfound";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
