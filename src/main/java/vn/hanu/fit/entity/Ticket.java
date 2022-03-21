package vn.hanu.fit.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Airline airline;

    @ManyToOne
    private Airport departureAirport;

    @ManyToOne
    private Airport arrivalAirport;

    @ManyToOne
    private FlightClass flightClass;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Airplane airplane;

    private Timestamp departureTime;

    private Timestamp arrivalTime;

    private Integer cost;

    private int estimatedTime;

    private Integer handLuggage;

    private Integer registeredLuggage;

    private Integer serviceCharge;

    private Integer taxes;

    private Integer fees;

    private boolean available;

    private boolean isRoundTrip;
}
