package es.antoniogo.apps.management;

import es.antoniogo.apps.management.command.AnotherFakeCommand;
import es.antoniogo.apps.management.command.FakeCommand;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
        value = {"es.antoniogo.shared", "es.antoniogo.management","es.antoniogo.apps.management"}
)
public class ManagementApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
            put("fake", FakeCommand.class);
            put("another_fake", AnotherFakeCommand.class);
        }};
    }
}
