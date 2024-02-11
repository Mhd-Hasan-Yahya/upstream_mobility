package at.upstream_mobility.itacademy.bored.controler;

import at.upstream_mobility.itacademy.bored.client.BoredClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BoredEndpointTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private BoredClient client;

    private final String localUrl = "http://localhost:8080/activity";

    @Test
    void testGetRandomActivity_NoParams() {
        String result = testRestTemplate.getForObject(localUrl, String.class);

        assertNotNull(result);

        assertNotEquals("No activity found", result);
    }

    @ParameterizedTest
    @CsvSource({
            "music, 1, 0.0, '', 5188388, 0.0",
            "social, 1, 0.1, '', 1288934, 0.2",
    })
    void testGetAnActivity(String type, int participants, double price, String link, String key, double accessibility) {
        String expectedParams = client.getParams(type, participants, price, link, key, accessibility);
        String expectedActivity = client.getActivityByParams(expectedParams);

        String result = testRestTemplate.getForObject(localUrl + expectedParams, String.class);

        assertEquals(expectedActivity, result);
    }

    @Test
    void testGetAnActivityWith_NoActivityFound() {
        String result = testRestTemplate.getForObject(localUrl + "?type=sport", String.class);
        assertEquals("No activity found", result);
    }

}