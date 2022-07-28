package com.example.demo12.service.impl;

import com.example.demo12.DAO.LocationRepository;
import com.example.demo12.model.Location;
import com.example.demo12.service.ICRUDService;

import java.util.ArrayList;

public class LocationService implements ICRUDService<Location> {
    LocationRepository locationRepository = new LocationRepository();
    @Override
    public Location findById(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public ArrayList<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public void create(Location location) {
        locationRepository.create(location);
    }

    @Override
    public void update(Location location) {
        locationRepository.update(location);
    }

    @Override
    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }
}
