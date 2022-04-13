package vn.hanu.fit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@Table(name = "passengers")
@Entity
@NoArgsConstructor
public class Passenger implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Passenger(String fullName, String phoneNumber, String email, Date dateOfBirth, String identityNumber, boolean gender) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.identityNumber = identityNumber;
        this.gender = gender;
    }

    private String fullName;

    private String phoneNumber;

    private String email;

    private Date dateOfBirth;

    private String identityNumber;

    private boolean gender;
}
