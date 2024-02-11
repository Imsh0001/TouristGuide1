package com.example.touristguideapi.controller.repository;

import com.example.touristguideapi.controller.modul.TouristAttractions;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttractions> attractions;

    public TouristRepository() {
        this.attractions = new ArrayList<>();
        attractions.add(new TouristAttractions("Big Ben", "It is the 3th largest free-standing clock tower in the world. The clock has become a symbol of the England and London."));
        attractions.add(new TouristAttractions("The British Museum", " a public museum dedicated to human history, art and culture located in the Bloomsbury area of London."));
    }


    public void addAttraction(TouristAttractions attraction) {
        attractions.add(attraction);
    }


    public List<TouristAttractions> getAllAttractions() {
        return attractions;
    }

    public TouristAttractions getAttractionByName(String name) {
        for (TouristAttractions attraction : attractions) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }


    public void updateAttraction(String name, TouristAttractions updatedAttraction) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equals(name)) {
                attractions.set(i, updatedAttraction);
                return;
            }
        }
    }

    public void deleteAttraction(String name) {
        attractions.removeIf(attraction -> attraction.getName().equals(name));
    }
}

