package org.restrover.domain;

import java.util.Map;

public interface RoverRepository {
    void create(String id, Rover rover);

    Map<String, Rover> getAll();

    Rover getRover(String id);
}
