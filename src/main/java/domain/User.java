package domain;


import java.util.Date;

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

    public User(String id, String email, String name, String surname, String workplace, String residence, String origin, String university, Date birthdate) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.workplace = workplace;
        this.residence = residence;
        this.origin = origin;
        this.university = university;
        this.birthdate = birthdate;
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

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
}