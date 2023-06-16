package org.example.repositories;

import org.example.domain.Rover;

import java.util.Map;

public class InMemoryRoverRepository implements RoverRepository {

    private final Map<String, Rover> rovers;

    public InMemoryRoverRepository(Map<String, Rover> rovers) {

        this.rovers = rovers;
    }

    @Override
    public void save(String id, Rover rover) {
        rovers.put(id, rover);
    }

    @Override
    public Rover getRoverById(String id) {
        return rovers.get(id);
    }



}
