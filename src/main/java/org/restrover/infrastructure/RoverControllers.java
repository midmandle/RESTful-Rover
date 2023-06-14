package org.restrover.infrastructure;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.restrover.application.RoverService;
import spark.Request;
import spark.Response;

public class RoverControllers {
    private final RoverService roverService;

    public RoverControllers(RoverService roverService) {
        this.roverService = roverService;
    }

    public String createRoverHandler(Request req, Response res) {
        String receivedUUID = extractPropertyFromBody(req, "id");
        roverService.createRover(receivedUUID);
        return "Created";
    }

    private static String extractPropertyFromBody(Request req, String property) {
        JsonObject JSONBody = Json.parse(req.body()).asObject();
        return JSONBody.getString(property, null);
    }

    public void sendCommandToRover(Request req, Response res) {
        throw new UnsupportedOperationException();
    }

    public String getRoverPositionHandler(Request req, Response res) {
        throw new UnsupportedOperationException();
    }
}