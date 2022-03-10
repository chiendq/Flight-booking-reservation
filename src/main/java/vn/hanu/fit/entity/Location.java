package vn.hanu.fit.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "location")
@Entity
@Data
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String city;

    private String airport;
}
