package vn.hanu.fit.entity;



import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 8, message = "Username must at least 8 characters ")
    private String username;

    @Size(min = 8, message = "Password must at least 8 characters ")
    private String password;

    @NotEmpty( message = "Full name must at least 8 characters ")
    private String fullname;

    @Size(min = 10, max = 11, message = "Incorrect phone number type")
    private String phone;

    private boolean gender;

    private Date dateofbirth;

    @Email
    private String email;

    private boolean enabled;

    private boolean isExist;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
