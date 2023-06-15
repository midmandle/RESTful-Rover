package org.example.controllers;

import com.eclipsesource.json.JsonObject;
import org.example.services.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.*;
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
}