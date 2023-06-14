package org.restrover.infrastructure;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restrover.domain.Rover;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@ExtendWith(MockitoExtension.class)
class InMemoryRoverRepositoryShould {
    @Mock
    Rover mockRover;

    @Test
    void persist_repository_called_when_calling_create(){
        // arrange
        InMemoryRoverRepository roverRepository = new InMemoryRoverRepository();
        String id = "some-uuid";
        Rover rover = new Rover(id);

        // act
        roverRepository.create(id, rover);

        // assert
        assertThat(roverRepository.getAll()).contains(entry(id, rover));
    }

    @Test
    void get_single_rover_by_id(){
        // arrange
        String id = "some-id";
        Rover rover = new Rover(id);
        InMemoryRoverRepository roverRepository = new InMemoryRoverRepository();
        roverRepository.create(id, rover);

        // act
        Rover actualRover = roverRepository.getRover(id);

        // assert
        assertThat(actualRover).isEqualTo(rover);
    }
}
