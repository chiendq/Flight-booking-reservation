package vn.hanu.fit.controller.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.repository.TicketRepository;
import vn.hanu.fit.entity.Ticket;
import vn.hanu.fit.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/ticket")
public class TicketRestController {
    @Autowired
    TicketRepository ticketRepository;


    @GetMapping()
    public List<Ticket> getAllTicket(){
        return ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") Long ticketId)
            throws ResourceNotFoundException {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("This ticket does not exist: " + ticketId));

        return ResponseEntity.ok().body(ticket);
    }

    @PostMapping
    public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long ticketId
            ,@Valid @RequestBody Ticket ticketDetails) throws ResourceNotFoundException{
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("This ticket does not exist: " + ticketId));

        ticket.setCost(ticketDetails.getCost());

        final Ticket updatedTicket = ticketRepository.save(ticket);

        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("{id}")
    public Map<String, Boolean> deleteTicket(@PathVariable(value = "id") Long ticketId)
            throws ResourceNotFoundException {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("This ticket does not exist: " + ticketId));

        ticketRepository.delete(ticket);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
