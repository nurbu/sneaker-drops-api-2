package com.pluralsight.sneakerdropsapi.controller;

import com.pluralsight.sneakerdropsapi.models.Sneaker;
import com.pluralsight.sneakerdropsapi.service.SneakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Sneaker> getAll() {
        return sneakerService.allSneakers();
    }
}