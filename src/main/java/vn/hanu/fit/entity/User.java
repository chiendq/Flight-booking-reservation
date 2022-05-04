package vn.hanu.fit.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Role role;

    @NotEmpty(message = "Full name must at least 8 characters ")
    private String fullName;

    @Size(min = 8, message = "Username must at least 8 characters ")
    private String username;

    @Size(min = 8, message = "Password must at least 8 characters ")
    private String password;

    @Size(min = 10, max = 11, message = "Incorrect phone number type")
    private String phone;

    private boolean gender;

    private Date dateOfBirth;

    @Email
    private String email;

    private boolean enabled;

    private boolean isExist;

    private String identityNumber;

    public User(String fullName, String username, String password, String phone, boolean gender, Date dateOfBirth, String email, boolean enabled, boolean isExist, String identityNumber) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.enabled = enabled;
        this.isExist = isExist;
        this.identityNumber = identityNumber;
    }
}
