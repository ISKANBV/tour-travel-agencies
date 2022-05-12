package az.coders.tourmanagement.controller.Impl;

import az.coders.tourmanagement.controller.TourController;
import az.coders.tourmanagement.dto.TourDTO;
import az.coders.tourmanagement.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour")
public class TourControllerImpl implements TourController {

    private final TourService service;

    public TourControllerImpl(TourService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/add")
    public void add(@RequestBody TourDTO tour) {
        service.add(tour);
    }

    @Override
    @GetMapping("/all")
    public List<TourDTO> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public TourDTO getById(@PathVariable("id") long id) {
        return service.getById(id);
    }

    @Override
    @PutMapping("/")
    public void update(@RequestBody TourDTO tour) {
        service.update(tour);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }

    @Override
    @DeleteMapping("/all")
    public void deleteAll() {
        service.deleteAll();
    }

    @Override
    @GetMapping("/destination/{destination}")
    public List<TourDTO> getTourByDestination(@PathVariable(name = "destination") String destination) {
        return service.getTourByDestination(destination);
    }
}
