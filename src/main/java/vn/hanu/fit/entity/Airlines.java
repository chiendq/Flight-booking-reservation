package vn.hanu.fit.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "airlines")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Airlines {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imgAPI;
}
