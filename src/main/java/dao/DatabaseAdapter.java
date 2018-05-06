package dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import domain.User;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by jakub on 05.05.18.
 */
@Repository
public class DatabaseAdapter {

    private static Firestore db;
    private final String PROJECT_ID = "socialize-c28dd";

    public DatabaseAdapter() {
        System.out.println("Initializing DatabaseAdapter");
        initializeApp();
    }

    private void initializeApp() {
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId(PROJECT_ID)
                        .build();
        db = firestoreOptions.getService();
        try {
            printUserById("xYnVhUt2ZwYXqyEvEje7");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Optional<User> getUserById(String id) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> future = db.collection("users")
                .document(id)
                .get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            User user = document.toObject(User.class);
            if (user != null) {
                System.out.println("Document data: " + document.getData());
                return Optional.of(user);
            }
        }
        System.out.println("No such document!");
        return Optional.empty();
    }

    public static ApiFuture<DocumentSnapshot> getFutureUserById(String id) {
        ApiFuture<DocumentSnapshot> future = db.collection("users")
                .document(id)
                .get();
        return future;
    }

    public static ApiFuture<QuerySnapshot> getFutureAllUsers() {
        ApiFuture<QuerySnapshot> future = db.collection("users").get();
        return future;
    }

    public void printUserById(String id) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> future = db.collection("users")
                .document(id)
                .get();
        DocumentSnapshot document = future.get();
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
    }

}
