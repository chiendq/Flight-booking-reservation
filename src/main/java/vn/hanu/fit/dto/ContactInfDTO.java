package vn.hanu.fit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfDTO {
    private String fullName;
    
    private String phoneNumber;
    
    private String email;
}
