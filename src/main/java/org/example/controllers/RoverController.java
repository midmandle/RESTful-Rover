package org.example.controllers;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.example.services.RoverService;
import spark.Request;
import spark.Response;

public class RoverController {
    public static final String APPLICATION_JSON = "application/json";
    public static final String CREATION_SUCCESS_MESSAGE = new JsonObject().add("message", "created").toString();
    public static final String MOVE_SUCCESS_MESSAGE = new JsonObject().add("message", "moved").toString();;
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
        response.status(201);
        response.type(APPLICATION_JSON);
        return CREATION_SUCCESS_MESSAGE;
    }

    public String moveRoverHandler(Request request, Response response) {
        JsonObject body = Json.parse(request.body()).asObject();
        String command = body.getString("command", null);
        String id = request.params("id");
        roverService.move(id, command);
        response.status(200);
        response.type(APPLICATION_JSON);
        return MOVE_SUCCESS_MESSAGE;
    }
}
