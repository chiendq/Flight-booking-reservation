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
    private Airlines airlines;

    private String airplane;

    private Timestamp departureTime;

    @ManyToOne
    private Location departureLocation;

    @ManyToOne
    private Location arrivalLocation;

    private Timestamp arrivalTime;

    private int estimatedTime;

    private Integer handLuggage;

    private Integer registeredLuggage;

    private Integer taxes;

    private Integer fees;

    private Integer serviceCharge;

    private Integer cost;

    private String luggageIconURL;

    private boolean sold;

    @ManyToOne
    private FlyClass flyClass;

}
