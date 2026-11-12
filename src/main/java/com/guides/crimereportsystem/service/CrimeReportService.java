package com.guides.crimereportsystem.service;

import com.guides.crimereportsystem.entity.CrimeReport;

import java.util.List;

public interface CrimeReportService {
    List<CrimeReport> getAllCrimeReports();
    CrimeReport saveCrimeReport(CrimeReport crimeReport);
    CrimeReport getCrimeReportById(Long id);
    CrimeReport updateCrimeReport(CrimeReport crimeReport);
    void deleteCrimeReportById(Long id);
}
