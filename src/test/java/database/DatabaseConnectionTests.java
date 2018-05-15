package database;


import dao.DatabaseAdapter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatabaseAdapter.class)
@AutoConfigureMockMvc
public class DatabaseConnectionTests {

    @Autowired
    private DatabaseAdapter db;

    @Test
    public void testFirestoreUsers() {
        assertFalse(db.users.getAllUsers().isEmpty());
    }

}
