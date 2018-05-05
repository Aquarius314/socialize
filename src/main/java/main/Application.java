package main;

import dao.PersonDao;
import domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        PersonDao.addPerson(new Person("00", "Jakub", "Wójcik", new Date()));
        PersonDao.addPerson(new Person("01", "Maciej", "Syrek", new Date()));
        SpringApplication.run(Application.class, args);
    }
}
