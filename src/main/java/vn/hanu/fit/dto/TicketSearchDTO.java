package vn.hanu.fit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.entity.Location;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TicketSearchDTO implements Serializable {
    private String fromLocationCode;

    private String toLocationCode;

    private Date departureTime;

    private Date arrivalTime;

    private int adultPassengerNumber;

    private int childPassengerNumber;

    private int babyPassengerNumber;

    private boolean economyClass;

    private boolean specialEconomyClass;

    private boolean businessClass;

    private boolean firstClass;

    @Override
    public String toString() {
        return "TicketSearchDTO{" +
                "fromLocationCode='" + fromLocationCode + '\'' +
                ", toLocationCode='" + toLocationCode + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", adultPassengerNumber=" + adultPassengerNumber +
                ", childPassengerNumber=" + childPassengerNumber +
                ", babyPassengerNumber=" + babyPassengerNumber +
                ", economyClass=" + economyClass +
                ", specialEconomyClass=" + specialEconomyClass +
                ", businessClass=" + businessClass +
                ", firstClass=" + firstClass +
                '}';
    }
}
