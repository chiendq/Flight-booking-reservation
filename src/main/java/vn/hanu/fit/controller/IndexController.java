package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hanu.fit.dto.TicketSearchDTO;
import vn.hanu.fit.entity.Location;
import vn.hanu.fit.entity.Ticket;
import vn.hanu.fit.repository.LocationRepository;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping("")
    public String home(Model model){
        List<Location> locations = locationRepository.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        return "index";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO){
        LOGGER.info(ticketSearchDTO.toString());
        return "index";
    }
}
