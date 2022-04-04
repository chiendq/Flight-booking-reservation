package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hanu.fit.dto.TicketSearchDTO;
import vn.hanu.fit.dto.TicketSelectedDTO;
import vn.hanu.fit.entity.Airport;
import vn.hanu.fit.entity.FlightClass;
import vn.hanu.fit.entity.Ticket;
import vn.hanu.fit.repository.AirlineRepository;
import vn.hanu.fit.repository.AirportRepository;
import vn.hanu.fit.repository.FlightClassRepository;
import vn.hanu.fit.repository.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    TicketRepository ticketRepository;

    List<FlightClass> flightClassList;

    @Autowired
    public void setFlightClasss(FlightClassRepository flightClassRepository) {
        this.flightClassList = flightClassRepository.findAll();
    }

    @Autowired
    AirportRepository airportRepository;

    @RequestMapping({"","/home"})
    public String home(Model model){
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassList);
        return "index";
    }

    @RequestMapping("/seat")
    public String seat(Model model){
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassList);
        return "seat";
    }
    @RequestMapping("/booking")
    public String book(Model model){
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassList);
        return "booking";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO, Model model){
        model.addAttribute("airports", airportRepository.findAll());

        String from = ticketSearchDTO.getDepartureAirportCode();
        String to = ticketSearchDTO.getArrivalAirportCode();
        String code = "" ;
        if(ticketSearchDTO.isEconomyClass()) code = flightClassList.get(0).getCode();
        else if(ticketSearchDTO.isSpecialEconomyClass()) code = flightClassList.get(1).getCode();
        else if(ticketSearchDTO.isBusinessClass()) code = flightClassList.get(2).getCode();
        else if(ticketSearchDTO.isFirstClass()) code = flightClassList.get(3).getCode();
        LOGGER.info(code);
        List<Ticket> tickets =  ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Code(from, to, code);
        LOGGER.info(String.valueOf(tickets));
        model.addAttribute("tickets", tickets);
        return "searchTicket";
    }


    @RequestMapping("/booking/{id}")
    public String booking(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO,
                          @PathVariable("id") Long id,
                          Model model)
    {
        model.addAttribute("ticketSearchDTO",ticketSearchDTO);
        LOGGER.info(ticketSearchDTO.toString());


        TicketSelectedDTO ticketSelectedDTO =  new TicketSelectedDTO();

        int adultNum = ticketSearchDTO.getAdultPassengerNumber();
        int childNum = ticketSearchDTO.getChildPassengerNumber();
        int babyNum = ticketSearchDTO.getBabyPassengerNumber();

        ticketSelectedDTO.setTicketSearchDTO(ticketSearchDTO);
        ticketSelectedDTO.setCustomerAdultInf(new ArrayList<>(adultNum));
        if(childNum > 0 ) ticketSelectedDTO.setCustomerChildInf(new ArrayList<>(childNum));
        if(babyNum > 0 ) ticketSelectedDTO.setCustomerBabyInf(new ArrayList<>(babyNum));



        model.addAttribute("ticketSelectedDTO", ticketSelectedDTO);
        return "payment";
    }

    @RequestMapping("/booking/success")
    public String bookingSuccess(){
        return "booking_success";
    }
}
