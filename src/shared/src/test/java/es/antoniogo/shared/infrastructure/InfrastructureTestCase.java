package es.antoniogo.shared.infrastructure;

import es.antoniogo.apps.Starter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Starter.class)
@SpringBootTest
public abstract class InfrastructureTestCase {

}
