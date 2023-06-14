package org.restrover.domain;

import java.util.List;

public interface RoverRepository {
    void create(Rover rover);

    List<Rover> getAll();
}
