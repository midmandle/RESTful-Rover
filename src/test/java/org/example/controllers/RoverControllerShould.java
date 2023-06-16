package org.example.controllers;

import com.eclipsesource.json.JsonObject;
import org.example.domain.Rover;
import org.example.services.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoverControllerShould {
    @Mock
    RoverService service;
    @Mock
    Request request;
    @Mock
    Response response;

    @Test
    void call_given_service_when_creating_rover(){
        // arrange
        String id = "some-id";
        RoverController roverController = new RoverController(service);

        // act
        when(request.body()).thenReturn(new JsonObject().add("id", id).toString());
        roverController.createRoverHandler(request, response);

        // assert
        verify(service).create(id);
    }
    @Test
    void return_appropriate_response_when_creating_rover(){
        // arrange
        String id = "some-id";
        RoverController roverController = new RoverController(service);
        when(request.body()).thenReturn(new JsonObject().add("id", id).toString());
        // act

        String controllerResponse = roverController.createRoverHandler(request, response);
        // assert
        verify(response).status(201);
        verify(response).type("application/json");
        assertThat(controllerResponse).isEqualTo(new JsonObject().add("message", "created").toString());
    }
    @Test
    void call_given_service_when_move_rover(){
        // arrange
        String id = "some-id";
        RoverController roverController = new RoverController(service);

        // act
        String command = "M";
        when(request.body()).thenReturn(new JsonObject().add("command", command).toString());
        when(request.params("id")).thenReturn(id);
        roverController.moveRoverHandler(request, response);

        // assert
        verify(service).move(id, command);

    }
    @Test
    void return_appropriate_response_when_moving_rover(){
        // arrange
        String id = "some-id";
        RoverController roverController = new RoverController(service);
        String command = "M";
        when(request.body()).thenReturn(new JsonObject().add("command", command).toString());
        when(request.params("id")).thenReturn(id);
        // act
        String controllerResponse = roverController.moveRoverHandler(request, response);
        // assert
        verify(response).status(200);
        verify(response).type("application/json");
        assertThat(controllerResponse).isEqualTo(new JsonObject().add("message", "moved").toString());
    }
    @Test
    void call_given_service_when_get_rover(){
        String id = "some-id";
        RoverController roverController = new RoverController(service);
        // act
        when(request.params("id")).thenReturn(id);
        Rover rover = new Rover(0,0,"N");
        when(service.get(id)).thenReturn(rover);
        roverController.getRoverHandler(request, response);
        // assert
        verify(service).get(id);
    }
    @Test
    void return_appropriate_response_when_getting_rover(){
        // arrange
        String id = "some-id";
        RoverController roverController = new RoverController(service);
        when(request.params("id")).thenReturn(id);
        Rover rover = new Rover(0,1,"N");
        when(service.get(id)).thenReturn(rover);
        // act
        String controllerResponse = roverController.getRoverHandler(request, response);
        // assert
        verify(response).status(200);
        verify(response).type("application/json");
        assertThat(controllerResponse).isEqualTo(new JsonObject()
                .add("X", 0)
                .add("Y", 1)
                .add("Facing", "N")
                .toString());
    }


}