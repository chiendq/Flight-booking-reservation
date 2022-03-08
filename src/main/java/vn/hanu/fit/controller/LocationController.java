package vn.hanu.fit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hanu.fit.entity.Location;
import vn.hanu.fit.repository.LocationRepository;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    LocationRepository locationRepository;

    @RequestMapping("/getall")
    public List<Location> getAllLocation(){
        return locationRepository.findAll();
    }

    @PostMapping("/add")
    public Location addLocation(@RequestBody Location location){
        return locationRepository.save(location);
    }
}
