package vn.hanu.fit.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "location")
@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String city;

    private String airport;
}
