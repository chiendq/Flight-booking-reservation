package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hanu.fit.entity.Ticket;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket getTicketByDepartureAirport_Code(String code);

    Ticket getTicketByArrivalAirport_Code(String code);

    List<Ticket> findAllByArrivalTime(Timestamp time); // get by exactly time yyyy-MM-dd hh:mm:ss

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_Code(String fromCode, String toCode);

    List<Ticket> findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Code(String fromCode, String toCode, String classCode);

}