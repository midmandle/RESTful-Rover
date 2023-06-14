package org.restrover.domain;

import java.util.Objects;

public class Rover {
    private final String id;

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
}
