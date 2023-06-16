package org.example.repositories;

import org.example.domain.Rover;

public interface RoverRepository {
     void save(String id, Rover rover);

    Rover getRoverById(String id);

}
