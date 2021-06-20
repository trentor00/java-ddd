package es.antoniogo.management.orders_counter.application.increment;

import es.antoniogo.management.orders.domain.OrderCreatedDomainEvent;
import es.antoniogo.management.orders.domain.OrderCreatedDomainEventMother;
import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderIdMother;
import es.antoniogo.management.orders_counter.OrdersCounterModuleUnitTestCase;
import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public final class IncrementOrdersCounterOnOrderCreatedTest extends OrdersCounterModuleUnitTestCase {
    IncrementOrdersCounterOnOrderCreated subscriber;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        subscriber = new IncrementOrdersCounterOnOrderCreated(
                new OrdersCounterIncrementer(repository, uuidGenerator)
        );
    }

    @Test
    void initialize_a_new_counter() {
        OrderCreatedDomainEvent event = OrderCreatedDomainEventMother.random();

        OrderId orderId   = OrderIdMother.create(event.aggregateId());
        OrdersCounter newCounter = OrdersCounterMother.withOne(orderId);

        shouldSearch();
        shouldGenerateUuid(newCounter.id().value());

        subscriber.on(event);

        shouldHaveSaved(newCounter);
    }

    @Test
    void increment_an_existing_counter() {
        OrderCreatedDomainEvent event = OrderCreatedDomainEventMother.random();

        OrderId       orderId           = OrderIdMother.create(event.aggregateId());
        OrdersCounter existingCounter    = OrdersCounterMother.random();
        OrdersCounter incrementedCounter = OrdersCounterMother.incrementing(existingCounter, orderId);

        shouldSearch(existingCounter);

        subscriber.on(event);

        shouldHaveSaved(incrementedCounter);
    }

    @Test
    void not_increment_an_already_incremented_order() {
        OrderCreatedDomainEvent event = OrderCreatedDomainEventMother.random();

        OrderId       orderId        = OrderIdMother.create(event.aggregateId());
        OrdersCounter existingCounter = OrdersCounterMother.withOne(orderId);

        shouldSearch(existingCounter);

        subscriber.on(event);
    }
}
