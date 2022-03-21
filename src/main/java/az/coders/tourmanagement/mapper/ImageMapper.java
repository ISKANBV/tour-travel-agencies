package az.coders.tourmanagement.mapper;

import az.coders.tourmanagement.dto.ImageDTO;
import az.coders.tourmanagement.entity.ImageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Mapper
public interface ImageMapper {

    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

//    @Mappings({
//            @Mapping(target = "id",source = "image.id"),
//            @Mapping(target = "name",source = "image.name"),
//            @Mapping(target = "originalFilename",source = "image.originalFilename"),
//            @Mapping(target = "contentType",source = "image.contentType"),
//            @Mapping(target = "size",source = "image.size"),
//            @Mapping(target = "bytes",source = "image.bytes"),
//    })
    ImageDTO toDTO(ImageEntity image) throws IOException;

//    @Mappings({
//            @Mapping(target = "name",source = "file.name"),
//            @Mapping(target = "originalFilename",source = "file.originalFilename"),
//            @Mapping(target = "contentType",source = "file.contentType"),
//            @Mapping(target = "size",source = "file.size"),
//            @Mapping(target = "bytes",source = "file.bytes"),
//    })
    ImageEntity toEntity(MultipartFile file) throws IOException;
}
