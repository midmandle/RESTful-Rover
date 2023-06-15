package org.example.model;

public record Rover(int xPosition, int yPosition, String direction) {
    public void move(int units) {
        throw new UnsupportedOperationException();
    }
}
