package com.guides.crimereportsystem.repository;

import com.guides.crimereportsystem.entity.Reporter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporterRepository extends JpaRepository<Reporter, Long> {
}
