package az.coders.tourmanagement.mapper;

import az.coders.tourmanagement.dto.ImageDTO;
import az.coders.tourmanagement.entity.ImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Mapper
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

    ImageDTO toDTO(ImageEntity image) throws IOException;

    ImageEntity toEntity(MultipartFile file) throws IOException;
}
