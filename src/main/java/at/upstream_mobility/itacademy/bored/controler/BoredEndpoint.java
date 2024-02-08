package at.upstream_mobility.itacademy.bored.controler;

import at.upstream_mobility.itacademy.bored.client.BoredClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
public class BoredEndpoint {
    private final BoredClient client;

    public BoredEndpoint(BoredClient client) {
        this.client = client;
    }

    @GetMapping
    public String getAnActivity(
            @RequestParam(defaultValue = "") String type,
            @RequestParam(defaultValue = "") Integer participants,
            @RequestParam(defaultValue = "") Double price,
            @RequestParam(defaultValue = "") String link,
            @RequestParam(defaultValue = "") String key,
            @RequestParam(defaultValue = "") Double accessibility
    ) {
        String params = client.getParams(type, participants, price, link, key, accessibility);
        return client.getActivityByParams(params);
    }
}
