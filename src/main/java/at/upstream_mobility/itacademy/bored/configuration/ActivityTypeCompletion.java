package at.upstream_mobility.itacademy.bored.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.CompletionContext;
import org.springframework.shell.CompletionProposal;
import org.springframework.shell.standard.ValueProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityTypeCompletion implements ValueProvider {

    private final List<String> types;

    public ActivityTypeCompletion(@Value("${types}") List<String> types) {
        this.types = types;
    }

    @Override
    public List<CompletionProposal> complete(CompletionContext completionContext) {
        return types.stream()
                .map(CompletionProposal::new)
                .collect(Collectors.toList());
    }
}
