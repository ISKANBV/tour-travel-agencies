package az.coders.tourmanagement.service.Impl;

import az.coders.tourmanagement.dto.TourDTO;
import az.coders.tourmanagement.entity.TourEntity;
import az.coders.tourmanagement.mapper.TourMapper;
import az.coders.tourmanagement.repository.TourRepository;
import az.coders.tourmanagement.service.TourService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class TourServiceImpl implements TourService {

    private final TourRepository repository;

    public TourServiceImpl(TourRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(TourDTO tour) {
        repository.save(TourMapper.INSTANCE.toEntity(tour));
    }

    @Override
    public List<TourDTO> getAll() {
        return repository.findAll().stream().map(TourMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }

    @Override
    public TourDTO getById(long id) {
        return TourMapper.INSTANCE.toDTO(repository.findById(id).orElseThrow(() -> new RuntimeException("id not found")));
    }

    @Override
    public void update(TourDTO tour) {
        Optional<TourEntity> tourEntity = repository.findById(TourMapper.INSTANCE.toEntity(tour).getId());
        tourEntity.map(entity -> {
            entity.setTitle(tour.getTitle());
            entity.setOverview(tour.getOverview());
            entity.setDestination(tour.getDestination());
            entity.setDuration(tour.getDuration());
            entity.setGroupSize(tour.getGroupSize());
            entity.setPrice(tour.getPrice());
            entity.setDate(tour.getDate());
            return null;
        });
//        tourEntity.setTitle(tour.getTitle());
//        tourEntity.setOverview(tour.getOverview());
//        tourEntity.setDestination(tour.getDestination());
//        tourEntity.setDuration(tour.getDuration());
//        tourEntity.setGroupSize(tour.getGroupSize());
//        tourEntity.setPrice(tour.getPrice());
//        tourEntity.setDate(tour.getDate());

        repository.save(tourEntity.get());
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<TourDTO> getTourByDestination(String destination) {
        return repository.findAllByDestination(destination).stream().map(TourMapper.INSTANCE::toDTO).collect(Collectors.toList());
    }
}
