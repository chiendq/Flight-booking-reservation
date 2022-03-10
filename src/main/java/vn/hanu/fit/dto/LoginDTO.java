package vn.hanu.fit.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO implements Serializable {
    private String username;

    private String password;

    private boolean status = false;

}
