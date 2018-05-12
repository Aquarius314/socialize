package main;

import dao.DatabaseAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("dao")
@ComponentScan("controllers")
@ComponentScan("main")
public class Application {

    public static void main(String[] args) {
        DatabaseAdapter db = new DatabaseAdapter();
        SpringApplication.run(Application.class, args);
    }
}
