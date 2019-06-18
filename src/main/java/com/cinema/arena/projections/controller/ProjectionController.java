package com.cinema.arena.projections.controller;
import com.cinema.arena.projections.service.ProjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectionController {

    @Autowired
    private ProjectionService projectionService;
}
