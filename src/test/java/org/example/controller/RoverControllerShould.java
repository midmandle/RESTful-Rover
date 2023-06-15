package org.example.controller;

import org.example.model.Rover;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class RoverControllerShould {

    @Mock
    private Request request;
    @Mock
    private Response response;

    @Test
    void call_land_new_rover_method_when_creating_a_rover(){
        //Arrange
        Rover rover = mock(Rover.class);
        RoverController roverController = new RoverController(rover);

        //Act
        roverController.createRoverHandler(request, response);
        //Assert
        verify(rover).landNewRover();
    }

}