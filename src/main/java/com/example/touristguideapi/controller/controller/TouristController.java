package com.example.touristguideapi.controller.controller;

import com.example.touristguideapi.controller.modul.TouristAttractions;
import com.example.touristguideapi.controller.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping
@Controller
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @PostMapping(path = "/attractions")
    public ResponseEntity<?> createAttraction(@RequestBody TouristAttractions attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(attraction, HttpStatus.CREATED);
    }

    @GetMapping("/attractions")
    public ResponseEntity<List<TouristAttractions>> getAllAttractions() {
        List<TouristAttractions> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/attractions/{name}")
    public ResponseEntity<?> getAttractionByName(@PathVariable String name) {
        TouristAttractions attraction = touristService.getAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(attraction, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/attractions/{name}")
    public ResponseEntity<?> updateAttraction(@PathVariable String name, @RequestBody TouristAttractions updatedAttraction) {
        touristService.updateAttraction(name, updatedAttraction);
        return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
    }

    @DeleteMapping("/attractions/{name}")
    public ResponseEntity<?> deleteAttraction(@PathVariable String name) {
        touristService.deleteAttraction(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
