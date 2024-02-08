package at.upstream_mobility.itacademy.bored.command;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoredCommandIntegrationTest {

    @Autowired
    private BoredCommand boredCommand;

    @Test
    void testGetAnActivity() {
        String expectedActivity = "Create a compost pile";
        String result = boredCommand.getAnActivity("diy", 1, 0.0, "", "8631548", 0.15);

        assertEquals(expectedActivity, result);
    }

    @Test
    void testGetAnActivity_NoParams() {
        String result = boredCommand.getAnActivity(null, null, null, null, null, null);

        assertNotNull(result);

        assertNotEquals("No activity found", result);
    }

    @Test
    void testGetAnActivity_NoActivityFound() {
        String result = boredCommand.getAnActivity("sport", null, null, null, null, null);

        assertEquals("No activity found", result);
    }
}