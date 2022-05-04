package vn.hanu.fit.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EditUserInfoDto {
    private String fullName;
    private String identityNumber;
    private String password;
    private String email;
    private boolean gender;
    private String phoneNumber;
    private Date dateOfBirth;
}
