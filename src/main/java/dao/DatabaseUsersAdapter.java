package dao;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import domain.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class DatabaseUsersAdapter extends FirestoreAdapter{

    DatabaseUsersAdapter(Firestore db, String path) {
        super(db, path);
    }

    public Optional<User> getUserById(String id) {
        ApiFuture<DocumentSnapshot> futureDoc = collection.document(id).get();
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

    public List<User> getAllUsers() {
        List<User> allUsers = new LinkedList<>();
        ApiFuture<QuerySnapshot> futureQuery = collection.get();
        try {
            List<QueryDocumentSnapshot> querySnapshot = futureQuery.get().getDocuments();
            if (!querySnapshot.isEmpty()) {
                for (DocumentSnapshot doc : querySnapshot) {
                    User user = doc.toObject(User.class);
                    if (user != null) {
                        allUsers.add(user);
                        System.out.println("User: " + user.getName() + " " + user.getSurname());
                    }
                }
            } else {
                System.out.println("User's list was empty!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUsers;
    }

    public boolean registerUser(User user) {
        ApiFuture<DocumentReference> futureDocRef = collection.add(user);
        try {
            DocumentReference docRef = futureDocRef.get();
            String id = docRef.getId();
            String displayName = user.getName().concat(" ").concat(user.getSurname());
            System.out.println("Registered user " + displayName + " with id " + id);
            docRef.update("id", id);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
            return false;
        }
    }

}
