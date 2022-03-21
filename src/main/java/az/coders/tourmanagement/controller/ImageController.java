package az.coders.tourmanagement.controller;

import az.coders.tourmanagement.dto.ImageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public interface ImageController {

    ResponseEntity<?> getAll();

    ResponseEntity<?> getById(long id);

    void add(MultipartFile file);

    void update(MultipartFile file);

    void delete(long id);

    void deleteAll();
}
