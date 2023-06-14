package org.restrover.application;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restrover.domain.Rover;
import org.restrover.domain.RoverRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoverServiceShould {
    @Mock
    RoverRepository roverRepository;

    @Test
    void call_create_on_given_repository_with_new_rover(){
        // arrange
        String id = "some-id";
        RoverService roverService = new RoverService(roverRepository);

        // act
        roverService.createRover(id);

        // assert
        Rover newRover = new Rover(id);
        verify(roverRepository).create(newRover);
    }
}