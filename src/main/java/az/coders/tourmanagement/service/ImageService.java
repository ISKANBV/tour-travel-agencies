package az.coders.tourmanagement.service;

import az.coders.tourmanagement.dto.ImageDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface ImageService {

    List<ImageDTO> getAll();

    ImageDTO getById(long id);

    void add(MultipartFile file);

    void update(MultipartFile file) throws IOException;

    void delete(long id);

    void deleteAll();
}
