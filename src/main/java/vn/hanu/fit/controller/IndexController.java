package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hanu.fit.dto.TicketSearchDTO;
import vn.hanu.fit.entity.Airport;
import vn.hanu.fit.repository.AirlineRepository;
import vn.hanu.fit.repository.AirportRepository;
import vn.hanu.fit.repository.FlightClassRepository;
import vn.hanu.fit.repository.TicketRepository;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    FlightClassRepository flightClassRepository;

    @Autowired
    AirportRepository airportRepository;

    @RequestMapping({"","/home"})
    public String home(Model model){
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassRepository.findAll());
        return "index";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO, Model model){
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("tickets", ticketRepository.findAll());
        LOGGER.info(ticketSearchDTO.toString());
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
