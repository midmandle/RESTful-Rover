package org.example.services;

import org.example.domain.Rover;
import org.example.repositories.RoverRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoverServiceShould {
    @Mock
    RoverRepository roverRepository;
    @Mock
    Rover rover;

    @Test
    void call_given_repository_when_create_rover_with_id_and_new_rover(){
        // arrange
        String id = "my_id";
        Rover rover = new Rover(0,0,"N");
        RoverService roverService = new RoverService(roverRepository);
        // act
        roverService.create(id);

        // assert
        verify(roverRepository).save(id, rover);
    }
    @Test
    void call_given_repository_when_move_rover_with_id_and_command(){
        // arrange
        String id = "my_id";
        String command = "M";
        RoverService roverService = new RoverService(roverRepository);
        when(roverRepository.getRoverById(id)).thenReturn(rover);
        // act
        roverService.move(id, command);
        // assert
        verify(rover).execute(command);
        verify(roverRepository).save(id, rover);
    }

}