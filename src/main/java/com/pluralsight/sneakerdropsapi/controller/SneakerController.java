package com.pluralsight.sneakerdropsapi.controller;

import com.pluralsight.sneakerdropsapi.models.Sneaker;
import com.pluralsight.sneakerdropsapi.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sneakers")
@CrossOrigin
public class SneakerController {

    private final SneakerService sneakerService;

    @Autowired
    public SneakerController(SneakerService sneakerService) {
        this.sneakerService = sneakerService;
    }

    @GetMapping
    public List<Sneaker> search(
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return sneakerService.search(year, model, brand, minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Sneaker sneaker = sneakerService.findById(id);
        if (sneaker == null) {
            return ResponseEntity.status(404).body("No sneaker found with id " + id);
        }
        return ResponseEntity.ok(sneaker);
    }
}