package com.guides.crimereportsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column @Getter @Setter private String address;
    @Column @Getter @Setter private String phoneNumber;

    public Station() {}

    public Station(Long id, String address, String phoneNumber) {
        super();
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
