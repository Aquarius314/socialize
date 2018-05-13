package domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String id;
    private String email;
    private String name;
    private String surname;
    private String workplace;
    private String residence;
    private String origin;
    private String university;
    private Date birthdate;

    public User() {}

    public static User fromRegistrationForm(RegistrationForm form) {
        User user = new User();
        user.name = form.getName();
        user.surname = form.getSurname();
        user.email = form.getEmail();
        return user;
    }

}