package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryRoverRepositoryTestModel {

    @Test
    void should_contain_new_landed_rover_identified_by_uuid(){
        // arrange
        String uuid = "754b4aee-3782-47ad-a524-354e70345c51";
        HashMap<String, Rover> landedRoverModels = new HashMap<>();
        RoverRepository roverRepository = new InMemoryRoverRepository(landedRoverModels);
        // act
        roverRepository.store(uuid);

        // assert
        Rover newRover = new Rover(0, 0, "N");
        assertTrue(landedRoverModels.containsKey(uuid));
        assertEquals(newRover,landedRoverModels.get(uuid));
    }

    @Test
    void should_find_a_rover_by_its_uuid(){
        //Arrange
        String uuid = "754b4aee-3782-47ad-a524-354e70345c22";
        Rover existingRover = new Rover(0, 0, "N");
        HashMap<String, Rover> existingRovers = new HashMap<>();
        existingRovers.put(uuid, existingRover);
        RoverRepository roverRepository = new InMemoryRoverRepository(existingRovers);

        //Act
        Rover roverFoundById = roverRepository.findRoverById(uuid);

        //Assert
        assertEquals(existingRover, roverFoundById);
    }

}