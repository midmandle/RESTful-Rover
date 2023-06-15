package org.restrover.domain;

import com.eclipsesource.json.JsonObject;

public class JsonRover extends Rover {
    private final Rover rover;

    public JsonRover(Rover rover) {
        super(rover.id);
        this.rover = rover;
    }


    public String toJson() {
        return new JsonObject()
                .add("X", rover.x)
                .add("Y", rover.y)
                .add("Direction", rover.direction)
                .toString();
    }
}
