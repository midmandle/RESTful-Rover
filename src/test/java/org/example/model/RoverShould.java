package org.example.model;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoverShould {

    @Test
    void call_repository_to_store_new_rover(){
        //Arrange
        Rover rover = new Rover();
        RoverRepository roverRepository = mock(RoverRepository.class);

        //Act
        rover.landNewRover();

        //Assert
        verify(roverRepository).store(rover);
    }

}