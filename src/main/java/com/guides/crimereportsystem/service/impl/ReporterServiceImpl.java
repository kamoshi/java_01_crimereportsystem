package com.guides.crimereportsystem.service.impl;

import com.guides.crimereportsystem.entity.Reporter;
import com.guides.crimereportsystem.repository.ReporterRepository;
import com.guides.crimereportsystem.service.ReporterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporterServiceImpl implements ReporterService {
    private final ReporterRepository reporterRepository;

    public ReporterServiceImpl(ReporterRepository reporterRepository) {
        super();
        this.reporterRepository = reporterRepository;
    }

    @Override
    public List<Reporter> getAllReporters() {
        return this.reporterRepository.findAll();
    }

    @Override
    public Reporter saveReporter(Reporter reporter) {
        return this.reporterRepository.save(reporter);
    }

    @Override
    public Reporter getReporterById(Long id) {
        return this.reporterRepository.findById(id).get();
    }

    @Override
    public Reporter updateReporter(Reporter reporter) {
        return this.reporterRepository.save(reporter);
    }

    @Override
    public void deleteReporterById(Long id) {
        this.reporterRepository.deleteById(id);
    }
}
