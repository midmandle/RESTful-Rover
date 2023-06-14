package acceptance;

import com.eclipsesource.json.JsonObject;
import org.restrover.application.RoverService;
import org.restrover.infrastructure.InMemoryRoverRepository;
import org.restrover.domain.RoverRepository;
import org.restrover.infrastructure.RoverControllers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoverAcceptanceTests {


    @Mock
    Request req;
    @Mock
    Response res;

    @Test
    void user_create_rover_and_send_simple_command(){
        // arrange
        String UUID = "4f342955-1927-4146-ab39-a467bce5580f";

        RoverRepository roverRepository = new InMemoryRoverRepository();
        RoverService roverService = new RoverService(roverRepository);
        RoverControllers roverControllers = new RoverControllers(roverService);

        // act
        when(req.body()).thenReturn(new JsonObject().add("id", UUID).toString());
        roverControllers.createRoverHandler(req, res);

        //TODO: Check that this works as expected
        when(req.body()).thenReturn(new JsonObject().add("command", "M").toString());
        roverControllers.sendCommandToRover(req, res);

        String actualResponse = roverControllers.getRoverPositionHandler(req, res);

        // assert
        verify(res).type("application/json");
        verify(res).status(200);
        String expectedResponse = new JsonObject()
                .add("X", 0)
                .add("Y", 1)
                .add("Direction", "N")
                .toString();

        assertEquals(expectedResponse, actualResponse);
    }

}
