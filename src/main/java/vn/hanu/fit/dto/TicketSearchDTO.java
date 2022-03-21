package vn.hanu.fit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class TicketSearchDTO implements Serializable {
    private String departureAirportCode;

    private String arrivalAirportCode;

    private Date departureTime;

    private Date arrivalTime;

    private int adultPassengerNumber;

    private int childPassengerNumber;

    private int babyPassengerNumber;

    private boolean economyClass;

    private boolean specialEconomyClass;

    private boolean businessClass;

    private boolean firstClass;

}
