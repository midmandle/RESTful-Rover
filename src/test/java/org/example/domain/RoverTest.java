package org.example.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RoverTest {
    @Test
    void should_move_North_when_executing_M_command_while_facing_north(){
        // arrange
        Rover rover = new Rover(0,0,"N");
        Rover expectedRover = new Rover(0,1,"N");
        String command = "M";
        // act
        rover.execute(command);
        // assert
        assertThat(rover).isEqualTo(expectedRover);
    }

}