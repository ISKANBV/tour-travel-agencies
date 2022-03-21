package az.coders.tourmanagement.controller.Impl;

import az.coders.tourmanagement.controller.ImageController;
import az.coders.tourmanagement.dto.ImageDTO;
import az.coders.tourmanagement.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

@RequestMapping("/images")
public class ImageControllerImpl implements ImageController {

    private final ImageService service;

    public ImageControllerImpl(ImageService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return (ResponseEntity<?>) service.getAll().stream().map(imageDTO -> ResponseEntity.ok()
                .header("fileName",imageDTO.getOriginalFilename())
                .contentType(MediaType.valueOf(String.valueOf(imageDTO)))
                .contentLength(imageDTO.getSize())
                .body(imageDTO.getBytes()));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") long id) {
        ImageDTO imageDTO = service.getById(id);
        return  ResponseEntity.ok()
                .header("fileName",imageDTO.getOriginalFilename())
                .contentType(MediaType.valueOf(String.valueOf(imageDTO)))
                .contentLength(imageDTO.getSize())
                .body(imageDTO.getBytes());
    }

    @Override
    @PostMapping("/add")
    public void add(@RequestParam("file") MultipartFile file) {
        service.add(file);
    }

    @Override
    @PutMapping("/")
    public void update(@RequestParam("file") MultipartFile file) {
        try {
            service.update(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") long id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping("/all")
    public void deleteAll() {
        service.deleteAll();
    }
}
