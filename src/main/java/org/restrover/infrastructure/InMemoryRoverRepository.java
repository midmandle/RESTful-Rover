package org.restrover.infrastructure;

import org.restrover.domain.Rover;
import org.restrover.domain.RoverRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryRoverRepository implements RoverRepository {
    private final Map<String, Rover> rovers = new HashMap<>();

    @Override
    public void create(Rover rover) {
        rovers.put(rover.getId(), rover);
    }

    @Override
    public Map<String, Rover> getAll() {
        return rovers;
    }

    @Override
    public Rover getRover(String id) {
        return rovers.getOrDefault(id, new Rover(""));
    }
}
