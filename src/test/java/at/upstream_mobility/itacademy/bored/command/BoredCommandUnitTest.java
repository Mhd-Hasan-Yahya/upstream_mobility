package at.upstream_mobility.itacademy.bored.command;
import at.upstream_mobility.itacademy.bored.client.BoredClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class BoredCommandUnitTest {

    @Autowired
    private BoredCommand command;
    @MockBean
    private BoredClient client;

    @Test
    public void testGetSpecificActivity() {
        when(client.getParams(anyString(), anyInt(), anyDouble(), anyString(), anyString(), anyDouble()))
                .thenReturn("Test-Params");
        when(client.getActivityByParams("Test-Params"))
                .thenReturn("Test-Activity");

        String result = command.getSpecificActivity("type", 1, 0.1, "link", "key", 0.99);

        verify(client).getParams("type", 1, 0.1, "link", "key", 0.99);
        verify(client).getActivityByParams("Test-Params");
        assertEquals("Test-Activity", result);
    }



}