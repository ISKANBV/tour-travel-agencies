package az.coders.tourmanagement.mapper;

import az.coders.tourmanagement.dto.TourDTO;
import az.coders.tourmanagement.entity.TourEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface TourMapper {

    TourMapper INSTANCE = Mappers.getMapper(TourMapper.class);

    TourDTO toDTO(TourEntity tour);

    TourEntity toEntity(TourDTO tourDTO);
}
