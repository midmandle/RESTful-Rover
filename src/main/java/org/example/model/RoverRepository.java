package org.example.model;

public interface RoverRepository {
    void store(String UUID);
    void findRoverById(String uuid);
}
