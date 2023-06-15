package acceptance;

import com.eclipsesource.json.JsonObject;
import org.example.controllers.RoverController;
import org.example.repositories.InMemoryRoverRepository;
import org.example.repositories.RoverRepository;
import org.example.services.RoverService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spark.Request;
import spark.Response;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestRoverAcceptanceTests {
    @Mock
    Request request;
    @Mock
    Response response;
    @Test
    void name_later(){
        // arrange
        RoverRepository roverRepository = new InMemoryRoverRepository();
        RoverService roverService = new RoverService(roverRepository);
        RoverController roverController = new RoverController(roverService);

        when(request.body()).thenReturn(new JsonObject().add("id", "some_uuid").toString());
        when(request.params("id")).thenReturn("some_uuid");
        // act
        roverController.createRoverHandler(request, response);
        when(request.body()).thenReturn(new JsonObject().add("command", "M").toString());
        roverController.moveRoverHandler(request, response);
        String actualResponse = roverController.getRoverHandler(request, response);
        // assert
        String expectedResponse = new JsonObject()
                .add("X", 0)
                .add("Y", 1)
                .add("Facing", "N")
                .toString();
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }




}
