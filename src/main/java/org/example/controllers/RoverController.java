package org.example.controllers;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.example.services.RoverService;
import spark.Request;
import spark.Response;

public class RoverController {
    private final RoverService roverService;

    public RoverController(RoverService roverService) {

        this.roverService = roverService;
    }

    public String getRoverHandler(Request request, Response response) {
        throw new UnsupportedOperationException();
    }

    public String createRoverHandler(Request request, Response response) {
        JsonObject body = Json.parse(request.body()).asObject();
        String id = body.getString("id", null);
        roverService.create(id);
        return "";
    }

    public String moveRoverHandler(Request request, Response response) {
        throw new UnsupportedOperationException();
    }
}
