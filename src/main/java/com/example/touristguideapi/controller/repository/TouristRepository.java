package com.example.touristguideapi.controller.repository;

import com.example.touristguideapi.controller.modul.TouristAttractions;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttractions> attraction;

    public TouristRepository() {
        this.attraction = new ArrayList<>();
        attraction.add(new TouristAttractions("Buckingham Palace", "The official residence of the British monarch in London, Buckingham Palace is an iconic symbol of the British monarchy."));
        attraction.add(new TouristAttractions("Big Ben", "an iconic landmark in London, is a notable clock tower celebrated for its grandeur and historical significance."));
        attraction.add(new TouristAttractions("The British Museum", "The British Museum, situated in London, is a renowned cultural institution boasting an extensive collection of ancient artifacts and artworks."));
        attraction.add(new TouristAttractions("Windsor Castle", "Windsor Castle, a venerable fortress in England, holds the distinction of being the largest and oldest continually inhabited castle worldwide."));
    }


    public void addAttraction(TouristAttractions attractions) {
        attraction.add(attractions);
    }


    public List<TouristAttractions> getAllAttractions() {
        return attraction;
    }

    public TouristAttractions getAttractionByName(String name) {
        for (TouristAttractions attraction : attraction) {
            if (attraction.getName().equals(name)) {
                return attraction;
            }
        }
        return null;
    }


    public void updateAttraction(String name, TouristAttractions updatedAttraction) {
        for (int i = 0; i < attraction.size(); i++) {
            if (attraction.get(i).getName().equalsIgnoreCase(name)) {
                attraction.set(i, updatedAttraction);
                return ;
            }
        }
    }

    public void deleteAttraction(String name) {
        attraction.removeIf(attraction -> attraction.getName().equalsIgnoreCase(name));
    }
}

