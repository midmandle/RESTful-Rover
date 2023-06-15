package org.example.model;

import java.util.HashMap;

public class InMemoryRoverRepository implements RoverRepository {
    private final HashMap<String, Rover> landedRoverModels;

    public InMemoryRoverRepository(HashMap<String, Rover> landedRoverModels) {
        this.landedRoverModels = landedRoverModels;
    }

    public InMemoryRoverRepository() {
        this.landedRoverModels = new HashMap<>();
    }

    @Override
    public void store(String UUID) {
        landedRoverModels.put(UUID, new Rover(0,0,"N"));
    }

    @Override
    public Rover findRoverById(String uuid) {
        return null;
    }
}
