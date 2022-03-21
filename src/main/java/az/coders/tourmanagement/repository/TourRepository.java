package az.coders.tourmanagement.repository;

import az.coders.tourmanagement.entity.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<TourEntity,Long> {

    List<TourEntity> findAllByDestination(String destination);
}
