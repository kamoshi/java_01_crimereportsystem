package com.guides.crimereportsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "reports")
public class CrimeReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Long id;

    @Column @Getter @Setter private String reporter;
    @Column @Getter @Setter private String description;
    @Column @Getter @Setter private Date time;
    @Column @Getter @Setter private String place;

    public CrimeReport() {
    }

    public CrimeReport(Long id, String reporter, String description, Date time, String place) {
        this.id = id;
        this.reporter = reporter;
        this.description = description;
        this.time = time;
        this.place = place;
    }
}
