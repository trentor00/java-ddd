package es.antoniogo.management.orders.application.create;

import es.antoniogo.management.orders.OrdersModuleUnitTestCase;
import es.antoniogo.management.orders.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

final class OrderCreatorTest extends OrdersModuleUnitTestCase {
    private OrderCreator creator;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        creator = new OrderCreator(repository, eventBus);
    }

    @Test
    void save_a_valid_order() {
        CreateOrderRequest request = CreateOrderRequestMother.random();

        Order order = OrderMother.fromRequest(request);
        OrderCreatedDomainEvent domainEvent = OrderCreatedDomainEventMother.fromOrder(order);

        creator.create(request);

        shouldHaveSaved(order);
        shouldHavePublished(domainEvent);
    }
}