package com.guides.crimereportsystem.service.impl;

import com.guides.crimereportsystem.entity.CrimeReport;
import com.guides.crimereportsystem.repository.CrimeReportRepository;
import com.guides.crimereportsystem.service.CrimeReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrimeReportServiceImpl implements CrimeReportService {
    private final CrimeReportRepository crimeReportRepository;

    public CrimeReportServiceImpl(CrimeReportRepository crimeReportRepository) {
        super();
        this.crimeReportRepository = crimeReportRepository;
    }

    @Override
    public List<CrimeReport> getAllCrimeReports() {
        return this.crimeReportRepository.findAll();
    }

    @Override
    public CrimeReport saveCrimeReport(CrimeReport crimeReport) {
        return this.crimeReportRepository.save(crimeReport);
    }

    @Override
    public CrimeReport getCrimeReportById(Long id) {
        return this.crimeReportRepository.findById(id).get();
    }

    @Override
    public CrimeReport updateCrimeReport(CrimeReport crimeReport) {
        return this.crimeReportRepository.save(crimeReport);
    }

    @Override
    public void deleteCrimeReportById(Long id) {
        this.crimeReportRepository.deleteById(id);
    }
}
