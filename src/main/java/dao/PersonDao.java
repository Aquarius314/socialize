package dao;

import domain.Person;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Created by jakub on 05.05.18.
 */
public class PersonDao {

    private static ArrayList<Person> persons = new ArrayList<>();

    public static void addPerson(Person person) {
        persons.add(person);
    }

    public static Optional<Person> getById(String id) {
        for (Person p : persons) {
            if (p.getId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

}
