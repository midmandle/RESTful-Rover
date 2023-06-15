package org.restrover.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoverShould {
    @Test
    void advance_to_the_north_when_receiving_move_command_facing_north() {
        // arrange
        Rover rover = new Rover("some-id");

        // act
        rover.execute("M");

        // assert
        assertThat(rover.x).isEqualTo(0);
        assertThat(rover.y).isEqualTo(1);
        assertThat(rover.direction).isEqualTo("N");
    }
}