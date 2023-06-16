package org.example.repositories;

import org.example.domain.Rover;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class InMemoryRoverRepositoryTest {
    @Test
    void should_save_rover() {
        // arrange
        String id = "my_id";
        Rover rover = new Rover(0, 0, "N");

        Map<String, Rover> rovers = new HashMap<>();
        // act
        InMemoryRoverRepository inMemoryRepository = new InMemoryRoverRepository(rovers);
        inMemoryRepository.save(id, rover);

        // assert
        assertThat(rovers).containsEntry(id, rover);
    }

    @Test
    void should_get_rover_by_id() {
        // arrange
        String id = "my_id";
        Rover rover = new Rover(0, 0, "N");

        Map<String, Rover> rovers = new HashMap<>();
        rovers.put(id, rover);
        // act
        InMemoryRoverRepository inMemoryRepository = new InMemoryRoverRepository(rovers);
        Rover actualRover = inMemoryRepository.getRoverById(id);


        // assert
        assertThat(actualRover).isEqualTo(rover);
    }

    @Test
    void should_save_rover_updating_an_existing_one() {
        // arrange
        String id = "my_id";
        Rover rover = new Rover(0, 0, "N");
        Rover updatedRover = new Rover(0, 1, "N");
        Map<String, Rover> rovers = new HashMap<>();
        rovers.put(id, rover);
        InMemoryRoverRepository inMemoryRoverRepository = new InMemoryRoverRepository(rovers);
        // act
        inMemoryRoverRepository.save(id, updatedRover);
        // assert
        assertThat(rovers).containsEntry(id, updatedRover);
    }

}
