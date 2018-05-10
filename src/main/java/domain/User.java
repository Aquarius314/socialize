package domain;

import com.google.cloud.firestore.annotation.Exclude;

import java.util.Date;

/**
 * Created by jakub on 05.05.18.
 */
public class User {

    private String id;
    private String email;
    private String name;
    private String surname;
    private Date birthdate;

    public User() {}

    public User(String id, String email, String name, String surname, Date birthDate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthDate) {
        this.birthdate = birthDate;
    }
}
