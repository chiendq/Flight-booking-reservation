package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.hanu.fit.dto.TicketSearchDTO;
import vn.hanu.fit.entity.Location;
import vn.hanu.fit.repository.LocationRepository;
import vn.hanu.fit.repository.TicketRepository;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    TicketRepository ticketRepository;

    @RequestMapping({"","/home"})
    public String home(Model model){
        List<Location> locations = locationRepository.findAll();
        model.addAttribute("locations", locations);
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        return "index";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO, Model model){
        model.addAttribute("locations", locationRepository.findAll());
        model.addAttribute("tickets", ticketRepository.findAll());
//        LOGGER.info(ticketSearchDTO.toString());
        return "searchTicket";
    }


    @RequestMapping("/booking/{id}")
    public String booking(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO,
                          Model model,
                          @PathVariable("id")Long id){
        model.addAttribute("ticketSearchDTO",ticketSearchDTO);
        LOGGER.info(ticketSearchDTO.toString());
        return "payment";
    }
}
