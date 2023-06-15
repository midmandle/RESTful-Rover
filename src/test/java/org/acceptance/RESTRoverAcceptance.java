package org.acceptance;

import com.eclipsesource.json.JsonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RESTRoverAcceptance {

    @Test
    void name_later() {
//        Generamos un ID
//        Creamos el rover
//        POST: /rover {id}
//        Ejecutar un commando
//        PUT: /rover/:id/move {units} [x, y, direction]
//        PUT: /rover/:id/rotate {direction, units} [x, y, direction]
//        PUT: /rover/:id/execute {fullCommand} [x, y, direction]
//        GET: /rover/:id [x, y, direction]

        // arrange
        RoverController roverController = new RoverController();

        String UUID = "83a857dc-6f65-40e4-88b6-c4487aa99fe4";
        JsonObject roverIdJSON = new JsonObject();
        roverIdJSON.add("id", UUID);

        JsonObject move2UnitsJSON = new JsonObject();
        move2UnitsJSON.add("units", 2);
        JsonObject move1UnitJSON = new JsonObject();
        move1UnitJSON.add("units", 1);
        JsonObject rotateRightJSON = new JsonObject();
        rotateRightJSON.add("direction", "R");
        rotateRightJSON.add("units", 1);
        JsonObject rotateLeftJSON = new JsonObject();
        rotateLeftJSON.add("direction", "L");
        rotateLeftJSON.add("units", 1);

        when(request.body()).thenReturn(
                roverIdJSON.toString(),
                move2UnitsJSON.toString(),
                rotateRightJSON.toString(),
                move2UnitsJSON.toString(),
                rotateLeftJSON.toString(),
                move1UnitJSON.toString()
        );

        when(request.params()).thenReturn(roverIdJSON.toString());

        // act
        roverController.createRoverHandler(request, response);
        roverController.moveHandler(request, response);
        roverController.rotateHandler(request, response);
        roverController.moveHandler(request, response);
        roverController.rotateHandler(request, response);
        String actualLocation = roverController.moveHandler(request, response);

        // assert
        JsonObject expectedLocation = new JsonObject();
        expectedLocation.add("x", 2);
        expectedLocation.add("y", 3);
        expectedLocation.add("direction", "N");

        assertEquals(expectedLocation.toString(), actualLocation);
    }

}