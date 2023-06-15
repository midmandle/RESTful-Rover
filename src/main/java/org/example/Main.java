package org.example;
import com.eclipsesource.json.JsonObject;
import org.example.controllers.RoverController;
import org.example.repositories.InMemoryRoverRepository;
import org.example.repositories.RoverRepository;
import org.example.services.RoverService;
import spark.Request;
import spark.Response;

import static spark.Spark.*;
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        RoverRepository roverRepository = new InMemoryRoverRepository();
        RoverService roverService = new RoverService(roverRepository);
        RoverController roverController = new RoverController(roverService);

        post("/rover", (req, res) -> roverController.createRoverHandler(req, res));
        get("/rover/:id", (req, res) -> roverController.getRoverHandler(req, res));
        put("/rover/:id/command", (req, res) -> roverController.moveRoverHandler(req, res));

    }

}