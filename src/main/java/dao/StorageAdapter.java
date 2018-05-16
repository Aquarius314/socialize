package dao;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;

@Repository
public class StorageAdapter {

    private Bucket bucket;

    public StorageAdapter() {
        System.out.println("Initializing StorageAdapter");
        try {
            FileInputStream serviceAccount = new FileInputStream("serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setStorageBucket("socialize-c28dd.appspot.com")
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            System.out.println("IO Exception!");
            e.printStackTrace();
        }

        bucket = StorageClient.getInstance().bucket();
    }

    public byte[] getImage(String filename) throws IOException {
        // TODO return file with provided filename
        Blob blob = bucket.get("andromeda.jpg");
        return blob.getContent();
    }
}
