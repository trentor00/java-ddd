package es.antoniogo.management.orders;

import es.antoniogo.apps.management.ManagementApplication;
import es.antoniogo.management.orders.infrastructure.persistence.InMemoryOrderRepository;
import es.antoniogo.shared.infrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ManagementApplication.class)
@SpringBootTest
public abstract class OrdersModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryOrderRepository repository;
}
