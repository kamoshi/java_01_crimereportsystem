package com.guides.crimereportsystem.service;

import com.guides.crimereportsystem.entity.Reporter;

import java.util.List;

public interface ReporterService {
    List<Reporter> getAllReporters();
    Reporter saveReporter(Reporter reporter);
    Reporter getReporterById(Long id);
    Reporter updateReporter(Reporter reporter);
    void deleteReporterById(Long id);
}
