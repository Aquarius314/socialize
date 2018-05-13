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

}