package org.restrover.domain;

import java.util.Objects;

public class Rover {
    private final String id;
    private String direction = "N";
    private int y = 0;
    private int x = 0;

    public Rover(String id) {
        this.id = id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return Objects.equals(id, rover.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void execute(String command) {
        if(command.equals("M") && direction.equals("N")){
            y += 1;
        }
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }
}
