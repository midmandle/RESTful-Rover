package org.restrover.infrastructure;

import com.eclipsesource.json.JsonObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.restrover.application.RoverService;
import spark.Request;
import spark.Response;

import static org.mockito.Mockito.*;
class RoverControllersTest {

    @Mock
    RoverService roverService;
    @Mock
    Response response;
    @Mock
    Request request;

    @Test
    void should_call_roverService_to_create_rover() {
        String uuid = "4f342955-1927-4146-ab39-a467bce5580f";
        RoverControllers roverControllers = new RoverControllers(roverService);
        when(request.body()).thenReturn(new JsonObject().add("id", uuid).toString());

        roverControllers.createRoverHandler(request, response);

        verify(roverService).createRover(uuid);
    }
}