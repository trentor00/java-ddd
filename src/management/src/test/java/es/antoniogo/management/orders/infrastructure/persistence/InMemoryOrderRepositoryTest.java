package es.antoniogo.management.orders.infrastructure.persistence;

import es.antoniogo.management.orders.OrdersModuleInfrastructureTestCase;
import es.antoniogo.management.orders.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class InMemoryOrderRepositoryTest extends OrdersModuleInfrastructureTestCase {
    @Test
    void save_a_order() {
        Order order = OrderMother.random();

        repository.save(order);
    }

    @Test
    void return_an_existing_order() {
        Order order = OrderMother.random();

        repository.save(order);

        assertEquals(Optional.of(order), repository.search(order.id()));
    }

    @Test
    void not_return_a_non_existing_order() {
        assertFalse(repository.search(OrderIdMother.random()).isPresent());
    }
}