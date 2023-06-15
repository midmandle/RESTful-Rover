package org.example.controller;

import org.example.model.Rover;
import spark.Request;
import spark.Response;

public class RoverController {

    private Rover rover;

    public RoverController(Rover rover) {
        this.rover = rover;
    }

    public String createRoverHandler(Request request, Response response) {
        rover.landNewRover();
        return null;
    }

    public String moveHandler(Request request, Response response) {
        throw new UnsupportedOperationException();
    }

    public String rotateHandler(Request request, Response response) {
        throw new UnsupportedOperationException();
    }
}
