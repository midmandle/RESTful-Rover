package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    @Test
    void should_move_rover_to_north(){
        // arrange
       Rover rover = new Rover("d7443d5b-de80-46fb-99ac-f678a28cea19");
        // act
       rover.move(1);
        // assert
        assertEquals("0:1:N", rover.toString());
    }

}