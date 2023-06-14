package org.restrover.infrastructure;

import com.eclipsesource.json.JsonArray;
import org.restrover.domain.Rover;
import org.restrover.domain.RoverRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRoverRepository implements RoverRepository {
    private final List<Rover> rovers = new ArrayList<>();

    @Override
    public void create(Rover rover) {
        rovers.add(rover);
    }

    @Override
    public List<Rover> getAll() {
        return rovers;
    }
}
