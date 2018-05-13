package dao;

import com.google.cloud.firestore.Firestore;

/**
 * Created by jakub on 13.05.18.
 */
public class DatabaseAuthenticationAdapter extends FirestoreAdapter {

    DatabaseAuthenticationAdapter(Firestore db, String path) {
        super(db, path);
    }

    public boolean emailRegistered(String email) {
        return true; // TODO validate email authentication!
    }
}
