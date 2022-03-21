package vn.hanu.fit.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Airport;
import vn.hanu.fit.repository.AirportRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {
    @Autowired
    private AirportRepository airportRepository;

    @GetMapping
    public List<Airport> getAirportList(){
        return airportRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Airport getAirportById(@PathVariable(value = "id") Long id){
        return airportRepository.findById(id).get();
    }

    @PostMapping
    public Airport addAirport(@RequestBody Airport airport){
        return airportRepository.save(airport);
    }

    @PutMapping(value = "/{id}")
    public void updateAirport(
            @PathVariable(value = "id") Long id,
            @RequestBody Airport airport) {
        if (airportRepository.existsById(id)) {
            airport.setId(id);
            airportRepository.save(airport);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAirport(
            @PathVariable(value = "id") Long id) {
        if (airportRepository.existsById(id)) {
            Airport airport = airportRepository.getById(id);
            airportRepository.delete(airport);
        }
    }

}
