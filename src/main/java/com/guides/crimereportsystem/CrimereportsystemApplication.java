package com.guides.crimereportsystem;

import com.guides.crimereportsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrimereportsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrimereportsystemApplication.class, args);
	}
}
