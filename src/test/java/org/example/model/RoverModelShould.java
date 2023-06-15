package org.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverModelShould {

    @Mock
    RoverRepository roverRepository;

    @Test
    void call_repository_to_store_new_rover(){
        //Arrange
        String UUID = "754b4aee-3782-47ad-a524-354e70345c51";
        RoverModel roverModel = new RoverModel(roverRepository);

        //Act
        roverModel.landNewRover(UUID);

        //Assert
        verify(roverRepository).store(UUID);
    }

    @Test
    void call_repository_to_find_existing_rover_when_moving(){
        // arrange
        int units = 2;
        String UUID = "8714d4c1-a369-41ed-af03-88138f62b9e9";
        RoverModel roverModel = new RoverModel(roverRepository);
        // act
        roverModel.moveRover(UUID, units);
        // assert
        verify(roverRepository).findRoverById(UUID);
    }

    @Test
    void call_rover_move_when_moveRover_is_called(){
        //Arrange
        int units = 2;
        Rover rover = mock(Rover.class);
        RoverModel roverModel = new RoverModel(roverRepository);
        String UUID = "985002fc-98ad-4f06-b45c-e74a755581dd";
        when(roverRepository.findRoverById(UUID)).thenReturn(rover);

        //Act
        roverModel.moveRover(UUID, units);
        //Assert
        verify(rover).move(units);
    }

}