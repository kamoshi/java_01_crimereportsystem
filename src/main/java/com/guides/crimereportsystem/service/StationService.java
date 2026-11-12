package com.guides.crimereportsystem.service;

import com.guides.crimereportsystem.entity.Station;

import java.util.List;

public interface StationService {
    List<Station> getAllStations();
    Station saveStation(Station station);
    Station getStationById(Long id);
    Station updateStation(Station station);
    void deleteStationById(Long id);
}
