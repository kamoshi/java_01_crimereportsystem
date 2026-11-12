package com.guides.crimereportsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User {
    public Admin() { }

    public Admin(Long id, String name, String phoneNumber, String address, String login, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.login = login;
        this.password = password;
    }}
