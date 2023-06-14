package org.restrover.infrastructure;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.restrover.application.RoverService;
import org.restrover.domain.Rover;
import spark.Request;
import spark.Response;

public class RoverControllers {
    public static final String TYPE_JSON = "application/json";
    private final RoverService roverService;

    public RoverControllers(RoverService roverService) {
        this.roverService = roverService;
    }

    public String createRoverHandler(Request req, Response res) {
        String receivedUUID = extractPropertyFromBody(req, "id");
        roverService.createRover(receivedUUID);

        res.type(TYPE_JSON);
        res.status(201);
        return "Created";
    }

    public String sendCommandToRover(Request req, Response res) {
        String roverId = req.params().get("id");
        String command = extractPropertyFromBody(req, "command");

        roverService.executeCommand(roverId, command);
        res.status(200);
        res.type(TYPE_JSON);

        return "Command sent";
    }

    public String getRoverPositionHandler(Request req, Response res) {
        String id = req.params().get("id");
        Rover rover = roverService.getRover(id);
        res.status(200);
        res.type(TYPE_JSON);
        return jsonForRover(rover);
    }

    private String jsonForRover(Rover rover) {
        return new JsonObject()
                .add("X", rover.getX())
                .add("Y", rover.getY())
                .add("Direction", rover.getDirection())
                .toString();
    }

    private static String extractPropertyFromBody(Request req, String property) {
        JsonObject JSONBody = Json.parse(req.body()).asObject();
        return JSONBody.getString(property, null);
    }
}