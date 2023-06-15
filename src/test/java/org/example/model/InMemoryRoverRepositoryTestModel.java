package org.example.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

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
        assertTrue(landedRoverModels.containsKey(uuid));
    }

}