package com.guides.crimereportsystem.repository;

import com.guides.crimereportsystem.entity.CrimeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeReportRepository extends JpaRepository<CrimeReport, Long> {
}
