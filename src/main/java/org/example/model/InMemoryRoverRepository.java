package org.example.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryRoverRepository implements RoverRepository {
    private final List<Rover> landedRovers;

    public InMemoryRoverRepository(List<Rover> landedRovers) {
        this.landedRovers = landedRovers;
    }

    public InMemoryRoverRepository() {
        this.landedRovers = new ArrayList<>();
    }

    @Override
    public void store(String UUID) {
        landedRovers.add(new Rover(UUID));
    }

    @Override
    public Rover findRoverById(String uuid) {
        Rover expectedIdRover = new Rover(uuid);
        int foundRoverIndex = landedRovers.indexOf(expectedIdRover);
        return landedRovers.get(foundRoverIndex);
    }
}
