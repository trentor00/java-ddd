package es.antoniogo.management.orders;

import es.antoniogo.management.ManagementContextInfrastructureTestCase;
import es.antoniogo.management.orders.domain.OrderRepository;
import es.antoniogo.management.orders.infrastructure.persistence.InMemoryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrdersModuleInfrastructureTestCase extends ManagementContextInfrastructureTestCase {
    protected InMemoryOrderRepository repository = new InMemoryOrderRepository();
    @Autowired
    protected OrderRepository mySqlCourseRepository;
}
