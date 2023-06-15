package org.restrover.domain;

import java.util.Objects;

public class Rover {
    protected final String id;
    protected String direction = "N";
    protected int y = 0;
    protected int x = 0;

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
}
