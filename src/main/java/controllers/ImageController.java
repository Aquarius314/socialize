package controllers;

import dao.StorageAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private StorageAdapter storage;

    @ResponseBody
    @GetMapping(
            value = "/img/{name}",
            produces = MediaType.IMAGE_JPEG_VALUE
    )
    public byte[] testPhoto(@PathVariable String name) throws IOException {
        return storage.getImage(name);
    }

}
