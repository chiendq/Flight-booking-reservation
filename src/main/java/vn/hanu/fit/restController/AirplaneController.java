package vn.hanu.fit.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Airplane;
import vn.hanu.fit.repository.AirplaneRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airplane")
public class AirplaneController {
    @Autowired
    private AirplaneRepository airplaneRepository;

    @GetMapping
    public List<Airplane> getAirplaneList(){
        return airplaneRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Airplane getAirplaneById(@PathVariable(value = "id") Long id){
        return airplaneRepository.findById(id).get();
    }

    @PostMapping
    public Airplane addAirplane(@RequestBody Airplane airplane){
        return airplaneRepository.save(airplane);
    }

    @PutMapping(value = "/{id}")
    public void updateAirplane(
            @PathVariable(value = "id") Long id,
            @RequestBody Airplane airplane) {
        if (airplaneRepository.existsById(id)) {
            airplane.setId(id);
            airplaneRepository.save(airplane);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAirplane(
            @PathVariable(value = "id") Long id) {
        if (airplaneRepository.existsById(id)) {
            Airplane airplane = airplaneRepository.getById(id);
            airplaneRepository.delete(airplane);
        }
    }

}
