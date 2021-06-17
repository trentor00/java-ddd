package es.antoniogo.management.orders;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public abstract class OrdersModuleUnitTestCase {
    protected OrderRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(OrderRepository.class);
    }

    protected void shouldHaveSaved(Order order) {
        verify(repository, atLeastOnce()).save(order);
    }
}
