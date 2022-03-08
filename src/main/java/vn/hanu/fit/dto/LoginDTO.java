package vn.hanu.fit.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {
    private String username;

    private String password;

    private boolean status = false;

}
