package com.guides.crimereportsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter protected Long id;

    @Column @Getter @Setter protected String name;
    @Column @Getter @Setter protected String phoneNumber;
    @Column @Getter @Setter protected String address;
    @Column @Getter @Setter protected String login;
    @Column @Getter @Setter protected String password;
}