package org.restrover;

import org.restrover.application.RoverService;
import org.restrover.infrastructure.RoverControllers;
import org.restrover.domain.RoverRepository;
import org.restrover.infrastructure.InMemoryRoverRepository;

import static spark.Spark.*;
@SuppressWarnings("ALL")
public class Main {
    private static RoverControllers roverControllers;

    public static void main(String[] args) {
        initializeRoverController();

        post("/rover", (req, res) -> roverControllers.createRoverHandler(req, res));
    }

    private static void initializeRoverController() {
        RoverRepository roverRepository = new InMemoryRoverRepository();
        RoverService roverService = new RoverService(roverRepository);
        roverControllers = new RoverControllers(roverService);
    }
}