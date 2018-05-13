package dao;

import com.google.cloud.firestore.*;
import org.springframework.stereotype.Repository;

/**
 * Created by jakub on 05.05.18.
 */
@Repository
public class DatabaseAdapter {

    private final String PROJECT_ID = "socialize-c28dd";
    public DatabaseUsersAdapter users;
    public DatabaseAuthenticationAdapter auth;

    public DatabaseAdapter() {
        System.out.println("Initializing DatabaseAdapter");
        Firestore firestore = getFirestoreInstance();
        users = new DatabaseUsersAdapter(firestore);
        auth = new DatabaseAuthenticationAdapter(firestore);
        System.out.println("DatabaseAdapter initialized successfully");
    }

    private Firestore getFirestoreInstance() {
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId(PROJECT_ID)
                        .build();
        Firestore firestore = firestoreOptions.getService();
        return firestore;
    }

}
