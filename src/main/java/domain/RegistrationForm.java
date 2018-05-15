package domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationForm {

    @Email(message = "Enter a valid email")
    private String email;

    @NotEmpty(message = "Enter your password")
    private String password;

    @NotEmpty(message = "Enter your name")
    private String name;

    @NotEmpty(message = "Enter your surname")
    private String surname;
}
