package es.antoniogo.management.orders.infrastructure.persistence;

import es.antoniogo.management.orders.OrdersModuleInfrastructureTestCase;
import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderIdMother;
import es.antoniogo.management.orders.domain.OrderMother;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
class MySqlOrderRepositoryTest extends OrdersModuleInfrastructureTestCase {
    @Test
    void save_a_order() {
        Order order = OrderMother.random();

        mySqlCourseRepository.save(order);
    }

    @Test
    void return_an_existing_order() {
        Order order = OrderMother.random();

        mySqlCourseRepository.save(order);

        assertEquals(Optional.of(order), mySqlCourseRepository.search(order.id()));
    }

    @Test
    void not_return_a_non_existing_order() {
        assertFalse(mySqlCourseRepository.search(OrderIdMother.random()).isPresent());
    }
}