package dao;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;

public abstract class FirestoreAdapter {

    protected Firestore db;
    protected CollectionReference collection;

    FirestoreAdapter(Firestore db, String path) {
        this.db = db;
        this.collection = db.collection(path);
    }

}
