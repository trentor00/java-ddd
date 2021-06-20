package es.antoniogo.apps.management.controller.orders_counter;

import es.antoniogo.apps.management.controller.ApplicationTestCase;
import es.antoniogo.management.orders.domain.OrderCreatedDomainEvent;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public final class OrdersCounterGetControllerTest extends ApplicationTestCase {
    @Test
    void get_the_counter_with_one_order() throws Exception {
        givenISendEventsToTheBus(
                new OrderCreatedDomainEvent(UUID.randomUUID().toString(), "DDD en Java")
        );

        assertResponse("/orders-counter", 200, "{'total': 1}");
    }

    @Test
    void get_the_counter_with_more_than_one_order() throws Exception {
        givenISendEventsToTheBus(
                new OrderCreatedDomainEvent(UUID.randomUUID().toString(), "DDD en Java"),
                new OrderCreatedDomainEvent(UUID.randomUUID().toString(), "DDD en PHP"),
                new OrderCreatedDomainEvent(UUID.randomUUID().toString(), "DDD en Cobol")
        );

        assertResponse("/orders-counter", 200, "{'total': 3}");
    }

    @Test
    void get_the_counter_with_more_than_one_order_having_duplicated_events() throws Exception {
        givenISendEventsToTheBus(
                new OrderCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java"),
                new OrderCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java"),
                new OrderCreatedDomainEvent("8f34bc99-e0e2-4296-a008-75f51f03aeb4", "DDD en Java"),
                new OrderCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP"),
                new OrderCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP"),
                new OrderCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP"),
                new OrderCreatedDomainEvent("3642f700-868a-4778-9317-a2d542d01785", "DDD en PHP"),
                new OrderCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol"),
                new OrderCreatedDomainEvent("92dd8402-69f3-4900-b569-3f2c2797065f", "DDD en Cobol")
        );

        assertResponse("/orders-counter", 200, "{'total': 3}");
    }
}
