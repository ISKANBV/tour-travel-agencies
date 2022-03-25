package az.coders.tourmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Stream;


public interface ImageController {

    Stream<ResponseEntity<byte[]>> getAll();

    ResponseEntity<?> getById(long id);

    void add(MultipartFile file);

    void update(MultipartFile file);

    void delete(long id);

    void deleteAll();
}
