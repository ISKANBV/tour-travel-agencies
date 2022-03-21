package az.coders.tourmanagement.service;

import az.coders.tourmanagement.dto.TourDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService{

    List<TourDTO> getTourByDestination(String destination);

    void add(TourDTO tour);

    List<TourDTO> getAll();

    TourDTO getById(long id);

    void update(TourDTO tour);

    void delete(long id);

    void deleteAll();
}
