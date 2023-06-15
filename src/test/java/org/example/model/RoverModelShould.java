package org.example.model;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RoverModelShould {

    @Test
    void call_repository_to_store_new_rover(){
        //Arrange
        String UUID = "754b4aee-3782-47ad-a524-354e70345c51";
        RoverRepository roverRepository = mock(RoverRepository.class);
        RoverModel roverModel = new RoverModel(roverRepository);

        //Act
        roverModel.landNewRover(UUID);

        //Assert
        verify(roverRepository).store(UUID);
    }

}