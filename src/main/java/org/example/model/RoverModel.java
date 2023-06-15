package org.example.model;

public class RoverModel {
    private final RoverRepository roverRepository;

    public RoverModel(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public void landNewRover(String UUID) {
        this.roverRepository.store(UUID);
    }
}