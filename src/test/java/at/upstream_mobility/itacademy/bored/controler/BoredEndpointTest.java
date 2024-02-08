package at.upstream_mobility.itacademy.bored.controler;
import at.upstream_mobility.itacademy.bored.client.BoredClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BoredEndpointTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private BoredClient client;

    private final String localUrl = "http://localhost:8080/activity";

    @Test
    void testGetAnActivity() {
        String type = "music";
        int participants = 1;
        double price = 0.0;
        String link = "";
        String key = "5188388";
        double accessibility = 0.0;
        String expectedParams = "type=music&participants=1&price=0.0&link=link&key=key&accessibility=0.0";
        String expectedActivity = "Write a song";

        when(client.getParams(type, participants, price, link, key, accessibility)).thenReturn(expectedParams);
        when(client.getActivityByParams(expectedParams)).thenReturn(expectedActivity);

        String result = testRestTemplate.getForObject(localUrl + "?type=" + type +
                "&participants=" + participants +
                "&price=" + price +
                "&link=" + link +
                "&key=" + key +
                "&accessibility=" + accessibility, String.class);
        System.out.println(result);

        assertEquals(expectedActivity, result);

    }

    @Test
    void testGetAnActivity_NoParams() {
        String result = testRestTemplate.getForObject(localUrl, String.class);
        assertNotNull(result);
    }

    @Test
    public void testGetAnActivityWith_NoActivityFound() {
        String result = testRestTemplate.getForObject(localUrl + "?type=sport", String.class);
        assertEquals("No activity found", result);
    }
}