package vn.hanu.fit.restController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Ticket;
import vn.hanu.fit.repository.TicketRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public List<Ticket> getTicketList(){
        return ticketRepository.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Ticket getTicketById(@PathVariable(value = "id") Long id){
        return ticketRepository.findById(id).get();
    }

    @GetMapping(value = {"/search{arrivalAirportCode}"})
    public Ticket getTicketByArrivalAirport(
            @RequestParam(value = "arrivalAirportCode") String arrivalAirportCode){
        return ticketRepository.getTicketByArrivalAirport_Code(arrivalAirportCode);
    }

    @GetMapping(value = "/searchby{arrivalTime}")
    public List<Ticket> getTicketByArrivalTime(
            @RequestParam(value = "arrivalTime") String arrivalTime) {
        return ticketRepository.findAllByArrivalTime(Timestamp.valueOf(arrivalTime)); // exactly time
    }


    @PostMapping
    public Ticket addTicket(@RequestBody Ticket ticket){
        return ticketRepository.save(ticket);
    }

    @PutMapping(value = "/{id}")
    public void updateTicket(
            @PathVariable(value = "id") Integer id,
            @RequestBody Ticket ticket) {
        if (ticketRepository.existsById(Long.valueOf(id))) {
            ticket.setId(Long.valueOf(id));
            ticketRepository.save(ticket);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTicket(
            @PathVariable(value = "id") Long id) {
        if (ticketRepository.existsById(id)) {
            Ticket ticket = ticketRepository.getById(id);
            ticketRepository.delete(ticket);
        }
    }

}
