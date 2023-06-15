package org.example.repositories;

import org.example.domain.Rover;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;


class InMemoryRoverRepositoryTest {
    @Test
    void store_rover(){
        // arrange
        String id = "my_id";
        Rover rover = new Rover(0,0,"N");

       Map<String, Rover> rovers = new HashMap<>();
        // act
        InMemoryRoverRepository inMemoryRepository = new InMemoryRoverRepository(rovers);
        inMemoryRepository.create(id, rover);

        // assert
        assertThat(rovers).containsEntry(id, rover);
    }

}