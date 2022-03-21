package vn.hanu.fit.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Passenger;
import vn.hanu.fit.repository.PassengerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    @Autowired
    private PassengerRepository passengerRepo;

    @GetMapping("")
    public List<Passenger> getPassengerList(){
        return passengerRepo.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Passenger getPassengerById(@PathVariable(value = "id") Long id){
        return passengerRepo.findById(id).get();
    }

    @PostMapping("")
    public Passenger addPassenger(@RequestBody Passenger passenger){
        return passengerRepo.save(passenger);
    }

    @PutMapping(value = "/{id}")
    public void updatePassenger(
            @PathVariable(value = "id") Long id,
            @RequestBody Passenger passenger) {
        if (passengerRepo.existsById(id)) {
            passenger.setId(id);
            passengerRepo.save(passenger);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletePassenger(
            @PathVariable(value = "id") Long id) {
        if (passengerRepo.existsById(id)) {
            Passenger passenger = passengerRepo.getById(id);
            passengerRepo.delete(passenger);
        }
    }

}
