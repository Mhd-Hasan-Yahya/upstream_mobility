package at.upstream_mobility.itacademy.bored.command;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoredCommandIntegrationTest {

    @Autowired
    private BoredCommand boredCommand;

    @Test
    public void testGetAnActivity() {
        String expectedActivity = "Create a compost pile";
        String result = boredCommand.getSpecificActivity("diy", 1, 0.0, "", "8631548", 0.15);

        assertEquals(expectedActivity, result);
    }

    @Test
    public void testGetAnActivity_NoParams() {
        String result = boredCommand.getSpecificActivity(null, null, null, null, null, null);

        assertNotNull(result);

        assertNotEquals("No activity found", result);
    }

    @Test
    public void testGetAnActivity_NoActivityFound() {
        String result = boredCommand.getSpecificActivity("sport", null, null, null, null, null);

        assertEquals("No activity found", result);
    }
}