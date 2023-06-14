package org.restrover.application;

import org.restrover.domain.RoverRepository;

public class RoverService {
    private final RoverRepository roverRepository;

    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }
}
