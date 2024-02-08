package at.upstream_mobility.itacademy.bored.client;

import at.upstream_mobility.itacademy.bored.data.Activity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class BoredClientUnitTest {

    @Autowired
    private BoredClient boredClient;

    @MockBean
    private RestTemplate restTemplate;

    private final String testUrl = "${testUrl}";

    @BeforeEach
    public void setUp() {
        boredClient = new BoredClient(restTemplate, testUrl);
    }

    @Test
    public void testGetActivityByParams() {
        Activity activity = new Activity();
        activity.setActivity("Test Activity");
        when(restTemplate.getForObject(testUrl + "type=music", Activity.class)).thenReturn(activity);

        String result = boredClient.getActivityByParams("type=music");

        assertEquals("Test Activity", result);
    }

    @Test
    public void testGetActivityByParams_NoActivityFound() {
        when(restTemplate.getForObject(testUrl + "type=not-exist", Activity.class)).thenReturn(null);

        String result = boredClient.getActivityByParams("type=not-exist");

        assertEquals("No activity found", result);
    }

    @Test
    public void testGetParams() {
        String params = boredClient.getParams("type", 2, 0.5, "link", "key", 0.3);

        assertEquals("?type=type&participants=2&price=0.5&link=link&key=key&accessibility=0.3", params);
    }

    @Test
    public void testGetParams_Empty() {
        String params = boredClient.getParams(null, null, null, null, null, null);
        assertEquals("", params);
    }
}