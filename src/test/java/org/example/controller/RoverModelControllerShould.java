package org.example.controller;

import com.eclipsesource.json.JsonObject;
import org.example.model.RoverModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverModelControllerShould {

    @Mock
    private Request request;
    @Mock
    private Response response;

    @Mock
    RoverModel roverModel;

    @Test
    void call_land_new_rover_method_when_creating_a_rover(){
        //Arrange
        String UUID = "754b4aee-3782-47ad-a524-354e70345c51";
        JsonObject roverIdJSON = new JsonObject();
        roverIdJSON.add("id", UUID);

        RoverController roverController = new RoverController(roverModel);
        when(request.body()).thenReturn(roverIdJSON.toString());

        //Act
        String roverHandler = roverController.createRoverHandler(request, response);
        //Assert
        verify(roverModel).landNewRover(UUID);
        assertEquals(new JsonObject().add("created", true).toString(), roverHandler);
    }

    @Test
    void call_rover_model_to_move(){
        //Arrange
        int units = 2;
        String UUID = "957989cd-efaa-47f9-93db-b83d95e3f2e6";
        JsonObject roverIdJSON = new JsonObject();
        roverIdJSON.add("id", UUID);

        RoverController roverController = new RoverController(roverModel);
        when(request.body()).thenReturn(roverIdJSON.toString());
        when(request.params("units")).thenReturn(String.format("%d", units));

        //Act
        roverController.moveHandler(request, response);

        //Assert
        verify(roverModel).moveRover(UUID,units);
    }

}