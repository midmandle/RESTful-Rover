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

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RoverAcceptanceTests {


    @Mock
    Request req;
    @Mock
    Response res;

    @Test
    void user_create_rover_and_send_simple_move_command(){
        // arrange
        String UUID = "4f342955-1927-4146-ab39-a467bce5580f";

        RoverRepository roverRepository = new InMemoryRoverRepository();
        RoverService roverService = new RoverService(roverRepository);
        RoverControllers roverControllers = new RoverControllers(roverService);

        when(req.body()).thenReturn(new JsonObject().add("id", UUID).toString(), new JsonObject().add("command", "M").toString());
        when(req.params()).thenReturn(new HashMap<>() {{
            put("id", UUID);
        }});

        // act
        roverControllers.createRoverHandler(req, res);
        roverControllers.sendCommandToRover(req, res);
        String actualResponse = roverControllers.getRoverPositionHandler(req, res);

        // assert
        verify(res, times(3)).type("application/json");
        verify(res, times(1)).status(201);
        verify(res, times(2)).status(200);
        String expectedResponse = new JsonObject()
                .add("X", 0)
                .add("Y", 1)
                .add("Direction", "N")
                .toString();

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

}
