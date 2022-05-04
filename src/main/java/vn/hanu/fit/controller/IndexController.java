package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hanu.fit.dto.TicketSearchDTO;
import vn.hanu.fit.entity.FlightClass;
import vn.hanu.fit.repository.*;

import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    BookingRepository bookingRepository;

    List<FlightClass> flightClassList;

    @Autowired
    public void setFlightClasss(FlightClassRepository flightClassRepository) {
        this.flightClassList = flightClassRepository.findAll();
    }

    @Autowired
    AirportRepository airportRepository;

    @RequestMapping({"", "/home"})
    public String home(Model model) {
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassList);
        return "index";
    }

}
