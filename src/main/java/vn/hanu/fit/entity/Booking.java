package vn.hanu.fit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Booking")
@NoArgsConstructor
public class Booking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    private Ticket ticket;

    private String code;

    private String status;

    private Timestamp bookedTime;

    public Booking(Passenger passenger, Payment payment, Ticket ticket, String code, String status, Timestamp bookedTime) {
        this.passenger = passenger;
        this.payment = payment;
        this.ticket = ticket;
        this.code = code;
        this.status = status;
        this.bookedTime = bookedTime;
    }
}
