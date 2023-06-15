package org.example.model;

import java.util.HashMap;

public class InMemoryRoverRepository implements RoverRepository {
    private final HashMap<String, Rover> landedRovers;

    public InMemoryRoverRepository(HashMap<String, Rover> landedRovers) {
        this.landedRovers = landedRovers;
    }

    public InMemoryRoverRepository() {
        this.landedRovers = new HashMap<>();
    }

    @Override
    public void store(String UUID) {
        landedRovers.put(UUID, new Rover(0,0,"N"));
    }

    @Override
    public Rover findRoverById(String uuid) {
        return landedRovers.get(uuid);
    }
}
