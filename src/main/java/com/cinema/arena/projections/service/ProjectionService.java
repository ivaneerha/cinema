package com.cinema.arena.projections.service;

import com.cinema.arena.projections.repository.ProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectionService {

    @Autowired
    private ProjectionRepository projectionRepository;
}
