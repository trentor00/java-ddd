package es.antoniogo.management.orders;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderRepository;
import es.antoniogo.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class OrdersModuleUnitTestCase extends UnitTestCase {
    protected OrderRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(OrderRepository.class);
    }

    protected void shouldHaveSaved(Order order) {
        verify(repository, atLeastOnce()).save(order);
    }
}
