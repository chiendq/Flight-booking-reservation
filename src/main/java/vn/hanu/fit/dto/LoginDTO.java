package vn.hanu.fit.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {
//    @NotEmpty(message = "Username can't left blank")
//    @Min(value = 8, message = "Username must at least 8 characters ")
    private String username;

//    @NotEmpty(message = "Password can't left blank")
//    @Min(value = 8, message = "Password must at least 8 characters ")
    private String password;

    private boolean status = false;

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
