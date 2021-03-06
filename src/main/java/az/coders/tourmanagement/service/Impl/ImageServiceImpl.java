package az.coders.tourmanagement.service.Impl;

import az.coders.tourmanagement.dto.ImageDTO;
import az.coders.tourmanagement.dto.TourDTO;
import az.coders.tourmanagement.entity.ImageEntity;
import az.coders.tourmanagement.mapper.ImageMapper;
import az.coders.tourmanagement.mapper.TourMapper;
import az.coders.tourmanagement.repository.ImageRepository;
import az.coders.tourmanagement.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    public ImageServiceImpl(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ImageDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(entity -> {
                    try {
                        return ImageMapper.INSTANCE.toDTO(entity);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ImageDTO getById(long id) {
        try {
            return ImageMapper.INSTANCE.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException("id not found")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(MultipartFile file) {
        try {
            repository.save(ImageMapper.INSTANCE.toEntity(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MultipartFile file) {
        Optional<ImageEntity> imageEntity = repository.findById(TourMapper.INSTANCE.toEntity((TourDTO) file).getId());
        imageEntity.map(entity -> {
            entity.setName(file.getName());
            entity.setOriginalFilename(file.getOriginalFilename());
            entity.setContentType(file.getContentType());
            entity.setSize(file.getSize());
            try {
                entity.setBytes(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        repository.save(imageEntity.get());
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
