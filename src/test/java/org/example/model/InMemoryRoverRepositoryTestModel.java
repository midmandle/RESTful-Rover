package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryRoverRepositoryTestModel {

    @Test
    void should_contain_new_landed_rover_identified_by_uuid(){
        // arrange
        String uuid = "754b4aee-3782-47ad-a524-354e70345c51";
        List<Rover> landedRovers = new ArrayList<>();
        RoverRepository roverRepository = new InMemoryRoverRepository(landedRovers);
        // act
        roverRepository.store(uuid);

        // assert
        Rover newRover = new Rover(uuid);
        assertEquals(newRover, landedRovers.get(0));
    }

    @Test
    void should_find_a_rover_by_its_uuid(){
        //Arrange
        String uuid = "754b4aee-3782-47ad-a524-354e70345c22";
        Rover existingRover = new Rover(uuid);
        List<Rover> existingRovers = List.of(existingRover);
        RoverRepository roverRepository = new InMemoryRoverRepository(existingRovers);

        //Act
        Rover roverFoundById = roverRepository.findRoverById(uuid);

        //Assert
        assertEquals(existingRover, roverFoundById);
    }

}