package es.antoniogo.management.orders_counter.application.find;

import es.antoniogo.management.orders_counter.OrdersCounterModuleUnitTestCase;
import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterMother;
import es.antoniogo.management.orders_counter.domain.OrdersCounterNotInitialized;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class OrdersCounterFinderTest extends OrdersCounterModuleUnitTestCase {
    OrdersCounterFinder finder;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        finder = new OrdersCounterFinder(repository);
    }

    @Test
    void find_an_existing_orders_counter() {
        OrdersCounter counter  = OrdersCounterMother.random();
        OrdersCounterResponse response = OrdersCounterResponseMother.create(counter.total().value());

        shouldSearch(counter);

        assertEquals(response, finder.find());
    }

    @Test
    void throw_an_exception_when_orders_counter_does_not_exists() {
        shouldSearch();

        assertThrows(OrdersCounterNotInitialized.class, () -> finder.find());
    }
}
