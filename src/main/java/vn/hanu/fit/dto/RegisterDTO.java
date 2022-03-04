package vn.hanu.fit.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
public class RegisterDTO {
    @Size(min = 8, message = "Username must at least 8 characters ")
    private String username;

    @Size(min = 8, message = "Password must at least 8 characters ")
    private String password;

    @NotEmpty( message = "Full name must at least 8 characters ")
    private String fullname;

    @Size(min = 10, max = 11, message = "Incorrect phone number type")
    private String phone;

//    @NotEmpty(message = "Gender can't left blank")
    private boolean gender;

    private Date dateofbirth;

    @Email
    private String email;

    private boolean status = false;

}
