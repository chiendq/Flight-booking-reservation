package vn.hanu.fit.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "tickets")
@NoArgsConstructor
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

    public Ticket(Airline airline, Airport departureAirport, Airport arrivalAirport, FlightClass flightClass, Airplane airplane, Timestamp departureTime, Timestamp arrivalTime, Integer cost, int estimatedTime, Integer handLuggage, Integer registeredLuggage, Integer serviceCharge, Integer taxes, Integer fees, boolean available) {
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.flightClass = flightClass;
        this.airplane = airplane;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.cost = cost;
        this.estimatedTime = estimatedTime;
        this.handLuggage = handLuggage;
        this.registeredLuggage = registeredLuggage;
        this.serviceCharge = serviceCharge;
        this.taxes = taxes;
        this.fees = fees;
        this.available = available;
    }
}
