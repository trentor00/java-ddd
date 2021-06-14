package es.antoniogo.management.orders.application.create;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class OrderCreatorTest {
    @Test
    void save_a_valid_order() {
        OrderRepository repository = mock(OrderRepository.class);
        OrderCreator    creator    = new OrderCreator(repository);

        Order order = new Order("some-id", "some-name");

        creator.create(order.id(), order.name());

        verify(repository, atLeastOnce()).save(order);
    }
}