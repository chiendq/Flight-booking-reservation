package vn.hanu.fit.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.FlightClass;
import vn.hanu.fit.repository.FlightClassRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flightClass")
public class FlightClassController {
    @Autowired
    private FlightClassRepository flightClassRepo;

    @GetMapping("")
    public List<FlightClass> getFlightClassList(){
        return flightClassRepo.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public FlightClass getFlightClassById(@PathVariable(value = "id") Long id){
        return flightClassRepo.findById(id).get();
    }

    @PostMapping("")
    public FlightClass addFlightClass(@RequestBody FlightClass flightClass){
        return flightClassRepo.save(flightClass);
    }

    @PutMapping(value = "/{id}")
    public void updateFlightClass(
            @PathVariable(value = "id") Long id,
            @RequestBody FlightClass flightClass) {
        if (flightClassRepo.existsById(id)) {
            flightClass.setId(id);
            flightClassRepo.save(flightClass);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFlightClass(
            @PathVariable(value = "id") Long id) {
        if (flightClassRepo.existsById(id)) {
            FlightClass flightClass = flightClassRepo.getById(id);
            flightClassRepo.delete(flightClass);
        }
    }

}
