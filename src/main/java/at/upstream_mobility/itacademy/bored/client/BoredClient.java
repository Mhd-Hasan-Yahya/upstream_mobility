package at.upstream_mobility.itacademy.bored.client;

import at.upstream_mobility.itacademy.bored.data.Activity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class BoredClient {

    private final RestTemplate restTemplate;
    private final String boredApiUrl;

    public BoredClient(RestTemplate restTemplate,
                       @Value("${boredApiUrl}") String boredApiUrl) {
        this.restTemplate = restTemplate;
        this.boredApiUrl = boredApiUrl;
    }

    public String getActivityByParams(String params) {
        Activity activity = restTemplate.getForObject(boredApiUrl + params.toLowerCase(), Activity.class);
//      System.out.println(boredApiUrl + params); \\ nur für die Präsentation
//      System.out.println(activity);
        if (activity != null && activity.getActivity() != null) {
            return activity.getActivity();
        } else {
            return "No activity found";
        }
    }

    public String getParams(String type, Integer participants, Double price, String link, String key, Double accessibility) {
        Map<String, String> paramMap = new LinkedHashMap<>();
        if (type != null && !type.isEmpty()) paramMap.put("type", type);
        if (participants != null) paramMap.put("participants", String.valueOf(participants));
        if (price != null) paramMap.put("price", String.valueOf(price));
        if (link != null && !link.isEmpty()) paramMap.put("link", link);
        if (key != null && !key.isEmpty()) paramMap.put("key", key);
        if (accessibility != null) paramMap.put("accessibility", String.valueOf(accessibility));

        String params = paramMap.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue())
                .collect(Collectors.joining("&"));

        return params.isEmpty() ? "" : "?" + params;
    }
}
