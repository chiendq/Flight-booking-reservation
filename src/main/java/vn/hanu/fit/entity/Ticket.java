package vn.hanu.fit.entity;


import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "departure")
    private String departure;

    @Column(name = "arrival")
    private String arrival;

    @Column(name = "departure_time")
    private Timestamp departureTime;

    @Column(name = "arrival_time")
    private Timestamp arrivalTime;

    @Column(name = "hand_luggage")
    private Integer handLuggage;

    @Column(name = "seat")
    private String seat;

    @Column(name = "cabin_class")
    private String cabinClass;

    @Column(name = "registered_luggage")
    private Integer registeredLuggage;

    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "cost")
    private String cost;
}
