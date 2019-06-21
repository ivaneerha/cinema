package com.cinema.arena.locations.controller;

import com.cinema.arena.locations.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;
}
