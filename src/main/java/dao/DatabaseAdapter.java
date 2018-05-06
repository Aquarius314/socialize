package dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import domain.User;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
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

    public static Optional<User> getUserById(String id) {
        ApiFuture<DocumentSnapshot> futureDoc = db.collection("users")
                .document(id)
                .get();
        try {
            DocumentSnapshot documentSnapshot = futureDoc.get();
            if (documentSnapshot.exists()) {
                User user = documentSnapshot.toObject(User.class);
                if (user != null) {
                    user.setId(documentSnapshot.getId());
                    System.out.println("Loaded user: " + user.getId());
                    return Optional.of(user);
                } else {
                    System.out.println("User loaded but was null!");
                }
            } else {
                System.out.println("Document " + id + " doesn't exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<User> getAllUsers() {
        ApiFuture<QuerySnapshot> futureQuery = db.collection("users").get();
        try {
            List<QueryDocumentSnapshot> querySnapshot = futureQuery.get().getDocuments();
            if (!querySnapshot.isEmpty()) {
                List<User> allUsers = new LinkedList<>();
                for (DocumentSnapshot doc : querySnapshot) {
                    User user = doc.toObject(User.class);
                    user.setId(doc.getId());
                    allUsers.add(user);
                    System.out.println("User: " + user.getName() + " " + user.getSurname());
                }
                return allUsers;
            } else {
                System.out.println("User's list was empty!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LinkedList<User>();
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
