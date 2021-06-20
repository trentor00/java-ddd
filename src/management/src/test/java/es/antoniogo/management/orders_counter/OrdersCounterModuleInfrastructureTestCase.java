package es.antoniogo.management.orders_counter;

import es.antoniogo.management.ManagementContextInfrastructureTestCase;
import es.antoniogo.management.orders_counter.domain.OrdersCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrdersCounterModuleInfrastructureTestCase extends ManagementContextInfrastructureTestCase {
    @Autowired
    protected OrdersCounterRepository repository;
}
