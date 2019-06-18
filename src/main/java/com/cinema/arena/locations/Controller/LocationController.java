package com.cinema.arena.locations.Controller;

import com.cinema.arena.locations.Service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;
}
