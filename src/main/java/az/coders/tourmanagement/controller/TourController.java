package az.coders.tourmanagement.controller;

import az.coders.tourmanagement.dto.TourDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface TourController{

    List<TourDTO> getTourByDestination(String destination);

    void add(TourDTO tour);

    List<TourDTO> getAll();

    TourDTO getById(long id);

    void update(TourDTO tour);

    void delete(long id);

    void deleteAll();
}
