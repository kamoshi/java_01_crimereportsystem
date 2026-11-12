package com.guides.crimereportsystem.controller;

import com.guides.crimereportsystem.entity.Reporter;
import com.guides.crimereportsystem.service.ReporterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reporters")
public class ReporterController {
    private final ReporterService reporterService;

    public ReporterController(ReporterService reporterService) {
        super();
        this.reporterService = reporterService;
    }

    @GetMapping("")
    public String listReporters(Model model) {
        model.addAttribute("reporters", this.reporterService.getAllReporters());
        return "reporters";
    }

    @GetMapping("/new")
    public String createReporterForm(Model model) {
        var reporter = new Reporter();
        model.addAttribute("reporter", reporter);
        return "create_reporter";
    }

    @PostMapping("")
    public String saveReporter(@ModelAttribute("reporter") Reporter reporter) {
        this.reporterService.saveReporter(reporter);
        return "redirect:/reporters";
    }

    @GetMapping("/edit/{id}")
    public String editReporterForm(@PathVariable Long id, Model model) {
        var reporter = this.reporterService.getReporterById(id);
        model.addAttribute("reporter", reporter);
        return "edit_reporter";
    }

    @PostMapping("/edit/{id}")
    public String updateReporter(
            @PathVariable Long id,
            @ModelAttribute("reporter") Reporter reporter
    ) {
        var existing = this.reporterService.getReporterById(id);

        existing.setId(id);
        existing.setAddress(reporter.getAddress());
        existing.setLogin(reporter.getLogin());
        existing.setName(reporter.getName());

        this.reporterService.saveReporter(existing);

        return "redirect:/reporters";
    }

    @DeleteMapping("/{id}")
    public String deleteReporter(@PathVariable Long id) {
        this.reporterService.deleteReporterById(id);

        return "redirect:/reporters";
    }
}
