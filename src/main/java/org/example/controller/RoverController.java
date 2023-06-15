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
        JsonObject bodyJSON = Json.parse(request.body()).asObject();
        int units = bodyJSON.getInt("units", 0);

        String roverID = request.params("id");
        roverModel.moveRover(roverID, units);
        return null;
    }

    public String rotateHandler(Request request, Response response) {
        throw new UnsupportedOperationException();
    }
}
