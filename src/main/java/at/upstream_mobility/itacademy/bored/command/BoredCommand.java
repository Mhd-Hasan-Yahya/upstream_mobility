package at.upstream_mobility.itacademy.bored.command;

import at.upstream_mobility.itacademy.bored.client.BoredClient;
import at.upstream_mobility.itacademy.bored.configuration.ActivityTypeCompletion;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;


@ShellComponent
public class BoredCommand {

    private final BoredClient client;

    public BoredCommand(BoredClient client) {
        this.client = client;
    }

    @ShellMethod(key = "get", value = "Gets an activity")
    public String getAnActivity(
            @ShellOption(defaultValue = "", valueProvider = ActivityTypeCompletion.class) String type,
            @ShellOption(defaultValue = "") Integer participants,
            @ShellOption(defaultValue = "") Double price,
            @ShellOption(defaultValue = "") String link,
            @ShellOption(defaultValue = "") String key,
            @ShellOption(defaultValue = "") Double accessibility

    ) {

        String params = client.getParams(type, participants, price, link, key, accessibility);
        return client.getActivityByParams(params);
    }
}
