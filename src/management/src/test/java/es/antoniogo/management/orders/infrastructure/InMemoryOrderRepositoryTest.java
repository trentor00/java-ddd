package es.antoniogo.management.orders.infrastructure;

import es.antoniogo.management.orders.domain.Order;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class InMemoryOrderRepositoryTest {
    @Test
    void save_a_valid_course() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();

        repository.save(new Order("some-id", "some-name"));
    }

    @Test
    void return_an_existing_order() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();
        Order order = new Order("some-id", "some-name");

        repository.save(order);

        assertEquals(Optional.of(order), repository.search(order.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        InMemoryOrderRepository repository = new InMemoryOrderRepository();

        assertFalse(repository.search("non-existing-id").isPresent());
    }
}