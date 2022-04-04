package vn.hanu.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketSelectedDTO {
    private Long id;

    private List<CustomerInfDTO> customerAdultInf;
    private List<CustomerInfDTO> customerChildInf;
    private List<CustomerInfDTO> customerBabyInf;

    private TicketSearchDTO ticketSearchDTO;

    private ContactInfDTO contactInf;
}
