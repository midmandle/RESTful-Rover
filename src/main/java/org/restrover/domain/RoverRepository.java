package org.restrover.domain;

import java.util.List;
import java.util.Map;

public interface RoverRepository {
    void create(Rover rover);

    Map<String, Rover> getAll();

    Rover getRover(String id);
}
