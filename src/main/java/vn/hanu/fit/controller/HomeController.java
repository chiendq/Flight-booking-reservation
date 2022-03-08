package vn.hanu.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hanu.fit.entity.Location;
import vn.hanu.fit.entity.Ticket;
import vn.hanu.fit.repository.LocationRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    LocationRepository locationRepository;

    @RequestMapping("")
    public String home(Model model){
        List<Location> locations = locationRepository.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("ticket", new Ticket());
        return "index";
    }
}
