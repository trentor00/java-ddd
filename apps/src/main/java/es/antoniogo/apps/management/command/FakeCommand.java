package es.antoniogo.apps.management.command;

import es.antoniogo.shared.infrastructure.cli.ConsoleCommand;
import org.springframework.stereotype.Service;

@Service
public final class FakeCommand extends ConsoleCommand {
    @Override
    public void execute(String[] args) {
        info("This is a fake command!");
    }
}
