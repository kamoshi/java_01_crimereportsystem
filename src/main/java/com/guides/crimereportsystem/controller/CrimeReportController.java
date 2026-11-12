package com.guides.crimereportsystem.controller;

import com.guides.crimereportsystem.entity.CrimeReport;
import com.guides.crimereportsystem.service.CrimeReportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reports")
public class CrimeReportController {
    private final CrimeReportService crimeReportService;

    public CrimeReportController(CrimeReportService crimeReportService) {
        super();
        this.crimeReportService = crimeReportService;
    }

    @GetMapping("")
    public String listCrimeReports(Model model) {
        model.addAttribute("reports", crimeReportService.getAllCrimeReports());
        return "reports";
    }

    @GetMapping("/new")
    public String createCrimeReportForm(Model model) {
        var crimeReport = new CrimeReport();
        model.addAttribute("report", crimeReport);
        return "create_report";

    }

    @PostMapping("")
    public String saveCrimeReport(@ModelAttribute("report") CrimeReport crimeReport) {
        crimeReportService.saveCrimeReport(crimeReport);
        return "redirect:/reports";
    }

    @GetMapping("/edit/{id}")
    public String editCrimeReportForm(@PathVariable Long id, Model model) {
        model.addAttribute("report", crimeReportService.getCrimeReportById(id));
        return "edit_report";
    }

    @PostMapping("/{id}")
    public String updateCrimeReport(
            @PathVariable Long id,
            @ModelAttribute("report") CrimeReport crimeReport
    ) {
        var existing = crimeReportService.getCrimeReportById(id);

        existing.setId(id);
        existing.setReporter(crimeReport.getReporter());
        existing.setDescription(crimeReport.getDescription());
        existing.setTime(crimeReport.getTime());
        existing.setPlace(crimeReport.getPlace());

        crimeReportService.updateCrimeReport(existing);

        return "redirect:/reports";
    }

    @DeleteMapping("/reports/{id}")
    public String deleteCrimeReport(@PathVariable Long id) {
        crimeReportService.deleteCrimeReportById(id);
        return "redirect:/reports";
    }
}
