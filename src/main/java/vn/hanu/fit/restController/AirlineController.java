package vn.hanu.fit.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Airline;
import vn.hanu.fit.repository.AirlineRepository;
import vn.hanu.fit.repository.AirlineRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airline")
public class AirlineController {
    @Autowired
    private AirlineRepository airlineRepository;

    @GetMapping
    public List<Airline> getAirlineList(){
        return airlineRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Airline getAirlineById(@PathVariable(value = "id") Long id){
        return airlineRepository.findById(id).get();
    }

    @PostMapping
    public Airline addAirline(@RequestBody Airline airline){
        return airlineRepository.save(airline);
    }

    @PutMapping(value = "/{id}")
    public void updateAirline(
            @PathVariable(value = "id") Long id,
            @RequestBody Airline airline) {
        if (airlineRepository.existsById(id)) {
            airline.setId(id);
            airlineRepository.save(airline);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAirline(
            @PathVariable(value = "id") Long id) {
        if (airlineRepository.existsById(id)) {
            Airline airline = airlineRepository.getById(id);
            airlineRepository.delete(airline);
        }
    }

}
