package domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created by jakub on 07.05.18.
 */
public class RegistrationForm {

    @Email(message = "Enter a valid email")
    private String email;

    @NotEmpty(message = "Enter your password")
    private String password;

    @NotEmpty(message = "Enter your name")
    private String name;

    @NotEmpty(message = "Enter your surname")
    private String surname;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
