package es.antoniogo.management.orders_counter.infrastructure.persistence;

import es.antoniogo.management.orders_counter.OrdersCounterModuleInfrastructureTestCase;
import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterMother;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
public class MySqlOrdersCounterRepositoryTest extends OrdersCounterModuleInfrastructureTestCase {
    @Test
    void return_an_existing_courses_counter() {
        OrdersCounter counter = OrdersCounterMother.random();

        repository.save(counter);

        assertEquals(Optional.of(counter), repository.search());
    }
}
