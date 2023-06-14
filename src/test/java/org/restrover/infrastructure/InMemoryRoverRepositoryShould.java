package org.restrover.infrastructure;

import org.junit.jupiter.api.Test;
import org.restrover.domain.Rover;

import javax.management.openmbean.CompositeData;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryRoverRepositoryShould {
    @Test
    void persist_repository_called_when_calling_create(){
        // arrange
        InMemoryRoverRepository roverRepository = new InMemoryRoverRepository();
        Rover rover = new Rover("some-uuid");

        // act
        roverRepository.create(rover);

        // assert
        assertThat(roverRepository.getAll()).contains(rover);
    }
}