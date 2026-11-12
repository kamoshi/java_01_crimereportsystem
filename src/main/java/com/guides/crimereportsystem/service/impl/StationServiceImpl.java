package com.guides.crimereportsystem.service.impl;

import com.guides.crimereportsystem.entity.Station;
import com.guides.crimereportsystem.repository.StationRepository;
import com.guides.crimereportsystem.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;

    public StationServiceImpl(StationRepository stationRepository) {
        super();
        this.stationRepository = stationRepository;
    }

    @Override
    public List<Station> getAllStations() {
        return this.stationRepository.findAll();
    }

    @Override
    public Station saveStation(Station station) {
        return this.stationRepository.save(station);
    }

    @Override
    public Station getStationById(Long id) {
        return this.stationRepository.findById(id).get();
    }

    @Override
    public Station updateStation(Station station) {
        return this.stationRepository.save(station);
    }

    @Override
    public void deleteStationById(Long id) {
        this.stationRepository.deleteById(id);
    }
}
