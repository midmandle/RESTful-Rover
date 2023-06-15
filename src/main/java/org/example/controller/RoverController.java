package org.example.controller;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import org.example.model.RoverModel;
import spark.Request;
import spark.Response;

public class RoverController {

    private RoverModel roverModel;

    public RoverController(RoverModel roverModel) {
        this.roverModel = roverModel;
    }

    public String createRoverHandler(Request request, Response response) {
        JsonObject responseJSON = new JsonObject();

        JsonObject roverIDJSON = Json.parse(request.body()).asObject();
        String UUID = roverIDJSON.getString("id", null);
        roverModel.landNewRover(UUID);

        responseJSON.add("created", true);
        return responseJSON.toString();
    }

    public String moveHandler(Request request, Response response) {
        JsonObject roverIDJSON = Json.parse(request.body()).asObject();
        String UUID = roverIDJSON.getString("id", null);

        int units = Integer.parseInt(request.params("units"));
        roverModel.moveRover(UUID, units);
        return null;
    }

    public String rotateHandler(Request request, Response response) {
        throw new UnsupportedOperationException();
    }
}
