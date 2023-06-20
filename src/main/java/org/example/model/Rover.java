package org.example.model;

import com.eclipsesource.json.JsonObject;

import java.util.Objects;

public class Rover {
    private final String identifier;
    private int xPosition;
    private int yPosition;
    private String direction;

    public Rover(String identifier) {
        this.identifier = identifier;
        this.xPosition = 0;
        this.yPosition = 0;
        this.direction = "N";
    }

    public void move(int units) {
        this.yPosition += units;
    }

    @Override
    public String toString() {
        return String.format("%d:%d:%s", xPosition, yPosition, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(identifier, rover.identifier);
    }

    public JsonObject toJSON() {
        JsonObject responseJSON = new JsonObject();
        responseJSON.add("x", xPosition);
        responseJSON.add("y", yPosition);
        responseJSON.add("direction", direction);
        return responseJSON;
    }
}
