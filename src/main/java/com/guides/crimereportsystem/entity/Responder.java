package com.guides.crimereportsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "responders")
public class Responder extends Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column @Getter @Setter private Long station;
    @Column @Getter @Setter private String currentPlace;
    @Column @Getter @Setter private Long currentJob;

    public Responder() {}

    public Responder(Long id, Long station, String currentPlace, Long currentJob) {
        this.id = id;
        this.station = station;
        this.currentPlace = currentPlace;
        this.currentJob = currentJob;
    }
}
