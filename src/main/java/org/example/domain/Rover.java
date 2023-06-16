package org.example.domain;

import java.util.Objects;

public class Rover {
    private final int x;
    private int y;
    private final String facing;

    public Rover(int x, int y, String facing) {
        this.x = x;
        this.y = y;
        this.facing = facing;
    }
    public void execute(String command) {
        if(command.equals("M") && facing.equals("N")) {
            y++;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getFacing() {
        return facing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rover rover = (Rover) o;
        return x == rover.x && y == rover.y && Objects.equals(facing, rover.facing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, facing);
    }


}
