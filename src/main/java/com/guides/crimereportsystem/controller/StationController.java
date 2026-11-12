package com.guides.crimereportsystem.controller;

import com.guides.crimereportsystem.entity.Station;
import com.guides.crimereportsystem.service.StationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stations")
public class StationController {
    private final StationService stationService;

    public StationController(StationService stationService) {
        super();
        this.stationService = stationService;
    }

    @GetMapping("")
    public String getStations(Model model) {
        model.addAttribute("stations", stationService.getAllStations());
        return "stations";
    }

    @GetMapping("/new")
    public String createStationForm(Model model) {
        var station = new Station();
        model.addAttribute("station", station);
        return "create_station";
    }

    @PostMapping("")
    public String saveStation(@ModelAttribute("station") Station station) {
        this.stationService.saveStation(station);
        return "redirect:/stations";
    }

    @GetMapping("/edit/{id}")
    public String editStationForm(@PathVariable Long id, Model model) {
        var station = this.stationService.getStationById(id);
        model.addAttribute("station", station);
        return "edit_station";
    }

    @PostMapping("/edit/{id}")
    public String editStation(
            @PathVariable Long id,
            @ModelAttribute("station") Station station
    ) {
        var existing = stationService.getStationById(id);
        existing.setId(id);
        existing.setAddress(station.getAddress());
        existing.setPhoneNumber(station.getPhoneNumber());

        stationService.updateStation(existing);
        return "redirect:/stations";
    }

    @DeleteMapping("/{id}")
    public String deleteStation(@PathVariable Long id) {
        stationService.deleteStationById(id);
        return "redirect:/stations";
    }
}
