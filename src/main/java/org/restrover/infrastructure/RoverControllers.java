package org.restrover.infrastructure;

import org.restrover.application.RoverService;
import spark.Request;
import spark.Response;

public class RoverControllers {
    private final RoverService roverService;

    public RoverControllers(RoverService roverService) {
        this.roverService = roverService;
    }

    public String createRoverHandler(Request req, Response res) {
        throw new UnsupportedOperationException();
    }

    public void sendCommandToRover(Request req, Response res) {
        throw new UnsupportedOperationException();
    }

    public String getRoverPositionHandler(Request req, Response res) {
        throw new UnsupportedOperationException();
    }
}