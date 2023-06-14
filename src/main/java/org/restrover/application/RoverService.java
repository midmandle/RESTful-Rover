package org.restrover.application;

import org.restrover.domain.Rover;
import org.restrover.domain.RoverRepository;

public class RoverService {
    private final RoverRepository roverRepository;

    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public void createRover(String uuid) {
        roverRepository.create(uuid, new Rover(uuid));
    }

    public void executeCommand(String id, String command) {
        Rover rover = roverRepository.getRover(id);
        rover.execute(command);
    }

    public Rover getRover(String id) {
        return roverRepository.getRover(id);
    }
}
