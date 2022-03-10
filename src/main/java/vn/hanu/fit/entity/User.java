package vn.hanu.fit.entity;



import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "dateofbirth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateofbirth;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;


}
