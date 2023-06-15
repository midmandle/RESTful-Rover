package org.example.services;

import org.example.domain.Rover;
import org.example.repositories.RoverRepository;

public class RoverService {
    private final RoverRepository roverRepository;

    public RoverService(RoverRepository roverRepository) {

        this.roverRepository = roverRepository;
    }

    public void create(String id) {
        Rover rover = new Rover(0,0,"N");
        roverRepository.create(id, rover);
    }
}