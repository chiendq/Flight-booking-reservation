package vn.hanu.fit.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SignupDTO {
    private String username;

    private String password;

    private String fullName;

    private String phoneNumber;

    private boolean gender;

    private String email;

    private Date dob;
}
