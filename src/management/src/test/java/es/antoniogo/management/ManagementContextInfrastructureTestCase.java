package es.antoniogo.management;

import es.antoniogo.apps.management.ManagementApplication;
import es.antoniogo.shared.infrastructure.InfrastructureTestCase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ManagementApplication.class)
@SpringBootTest
public abstract class ManagementContextInfrastructureTestCase extends InfrastructureTestCase {

}
