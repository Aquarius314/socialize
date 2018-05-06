package dao;

import domain.User;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by jakub on 05.05.18.
 */
public class UserDao {

    private static ArrayList<User> persons = new ArrayList<>();

    public static void addPerson(User person) {
        persons.add(person);
    }

    public static Optional<User> getById(String id) {
        for (User p : persons) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

}
