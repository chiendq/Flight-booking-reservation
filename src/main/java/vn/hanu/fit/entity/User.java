package vn.hanu.fit.entity;



import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotNull
    @Size(min = 8, max = 255, message = "Username is required")
    private String username;

    @Column(name = "password")
    @NotNull
    @Size(min = 8, max = 255, message = "Password is required")
    private String password;

    @NotNull
    @Column(name = "fullname")
    @Size(min = 8, max = 255, message = "Fullname is required")
    private String fullname;

    @Column(name = "phone")
    @Size(min = 10, max = 11, message = "Username is required")
    private String phone;

    @Column(name = "dateofbirth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateofbirth;

//    @NotNull( message = "Gender is required")
    @Column(name = "gender")
    private boolean gender;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    @Email(message = "Email is not valid")
    private String email;


}
