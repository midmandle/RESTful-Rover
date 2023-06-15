package org.example.model;

public interface RoverRepository {
    void store(String UUID);
    Rover findRoverById(String uuid);
}
