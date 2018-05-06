package main;

import dao.DatabaseAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        DatabaseAdapter db = new DatabaseAdapter();
        SpringApplication.run(Application.class, args);
    }
}
