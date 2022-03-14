package vn.hanu.fit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.entity.FlyClass;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class TicketDTO implements Serializable {

    private String airlines;

    private String airplane;

    private Timestamp fromTime;

    private Timestamp toTime;

    private int estimatedTime;

    private Integer handLuggage;

    private Integer registeredLuggage;

    private Integer taxes;

    private Integer fees;

    private Integer serviceCharge;

    private Integer cost;

    private FlyClass flyClass;
}
