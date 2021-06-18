package es.antoniogo.management.orders;

import es.antoniogo.management.orders.infrastructure.persistence.InMemoryOrderRepository;
import es.antoniogo.shared.infrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrdersModuleInfrastructureTestCase extends InfrastructureTestCase {
    @Autowired
    protected InMemoryOrderRepository repository;
}
