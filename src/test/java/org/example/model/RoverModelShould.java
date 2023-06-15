package org.example.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
    void call_repository_to_find_existing_rover(){
        // arrange
        int units = 2;
        String UUID = "8714d4c1-a369-41ed-af03-88138f62b9e9";
        RoverModel roverModel = new RoverModel(roverRepository);
        // act
        roverModel.moveRover(UUID, units);
        // assert
        verify(roverRepository).findRoverById(UUID);
    }

}