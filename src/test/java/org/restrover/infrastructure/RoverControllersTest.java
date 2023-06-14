package org.restrover.infrastructure;

import com.eclipsesource.json.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.restrover.application.RoverService;
import spark.Request;
import spark.Response;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoverControllersTest {

    @Mock
    RoverService roverService;
    @Mock
    Response response;
    @Mock
    Request request;
    private RoverControllers roverControllers;

    @BeforeEach
    void initialize(){
        roverControllers = new RoverControllers(roverService);
    }

    @Test
    void should_call_roverService_to_create_rover() {
        String uuid = "4f342955-1927-4146-ab39-a467bce5580f";

        when(request.body()).thenReturn(new JsonObject().add("id", uuid).toString());

        roverControllers.createRoverHandler(request, response);

        verify(roverService).createRover(uuid);
    }

    @Test
    void should_return_response_properties() {
        String uuid = "4f342955-1927-4146-ab39-a467bce5580f";
        when(request.body()).thenReturn(new JsonObject().add("id", uuid).toString());

        String createResult = roverControllers.createRoverHandler(request, response);

        verify(response).status(201);
        verify(response).type("application/json");
        String expectedOutput = "Created";
        assertThat(expectedOutput).isEqualTo(createResult);
    }

    @Test
    void should_pass_command_and_id_to_roverService() {
        // arrange
        String id = "some-id";
        String command = "M";
        when(request.params()).thenReturn(new HashMap<>() {{
            put("id", id);
        }});
        when(request.body()).thenReturn(new JsonObject().add("command", command).toString());

        // act
        roverControllers.sendCommandToRover(request, response);

        // assert
        verify(roverService).executeCommand(id, command);
    }

    @Test
    void should_return_200_and_sent_when_sending_command_to_rover() {
        // arrange
        String id = "some-id";
        String command = "M";
        when(request.params()).thenReturn(new HashMap<>() {{
            put("id", id);
        }});
        when(request.body()).thenReturn(new JsonObject().add("command", command).toString());

        // act
        String actualResponse = roverControllers.sendCommandToRover(request, response);

        // assert
        verify(response).type("application/json");
        verify(response).status(200);
        assertThat("Command sent").isEqualTo(actualResponse);
    }
}