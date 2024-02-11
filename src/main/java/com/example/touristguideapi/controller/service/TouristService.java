package com.example.touristguideapi.controller.service;

import com.example.touristguideapi.controller.modul.TouristAttractions;
import com.example.touristguideapi.controller.repository.TouristRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {
    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public void addAttraction(TouristAttractions attraction) {
        touristRepository.addAttraction(attraction);
    }

    public List<TouristAttractions> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }

    public TouristAttractions getAttractionByName(String name) {
        return touristRepository.getAttractionByName(name);
    }

    public void updateAttraction(String name, TouristAttractions updatedAttraction) {
        touristRepository.updateAttraction(name, updatedAttraction);
    }

    public void deleteAttraction(String name) {
        touristRepository.deleteAttraction(name);
    }
}
