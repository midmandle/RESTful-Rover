package org.restrover.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restrover.domain.Rover;
import org.restrover.domain.RoverRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoverServiceShould {
    @Mock
    RoverRepository roverRepository;
    @Mock
    Rover rover;
    private RoverService roverService;

    @BeforeEach
    void initialize(){
        roverService = new RoverService(roverRepository);
    }

    @Test
    void call_create_on_given_repository_with_new_rover(){
        // arrange
        String id = "some-id";


        // act
        roverService.createRover(id);

        // assert
        Rover newRover = new Rover(id);
        verify(roverRepository).create(id, newRover);
    }

    @Test
    void find_rover_and_execute_command(){
        // arrange
        String command = "M";
        String id = "some-id";
        when(roverRepository.getRover(id)).thenReturn(rover);

        // act
        roverService.executeCommand(id, command);

        // assert
        verify(rover).execute(command);
    }

    @Test
    void call_repository_to_get_rover_by_id_and_return_it(){
        // arrange
        String id = "some-id";
        Rover expectedRover = new Rover(id);
        when(roverRepository.getRover(id)).thenReturn(expectedRover);
        // act
        Rover actualRover = roverService.getRover(id);

        // assert
        assertThat(actualRover).isEqualTo(expectedRover);
    }
}