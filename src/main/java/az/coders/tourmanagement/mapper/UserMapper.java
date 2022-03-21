package az.coders.tourmanagement.mapper;

import az.coders.tourmanagement.dto.UserDTO;
import az.coders.tourmanagement.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "name", source = "user.username"),
            @Mapping(target = "email", source = "user.email"),
            @Mapping(target = "password", source = "user.password"),
            @Mapping(target = "roles", source = "user.roles"),
            @Mapping(target = "tours", source = "user.tours")
    })
    abstract UserDTO toDTO(User user);

    @Mappings({
            @Mapping(target = "id", source = "userDTO.userId"),
            @Mapping(target = "username", source = "userDTO.name"),
            @Mapping(target = "email", source = "userDTO.email"),
            @Mapping(target = "password", source = "userDTO.password"),
            @Mapping(target = "roles", source = "userDTO.roles"),
            @Mapping(target = "tours", source = "userDTO.tours")
    })
    abstract User toEntity(UserDTO userDTO);
}
