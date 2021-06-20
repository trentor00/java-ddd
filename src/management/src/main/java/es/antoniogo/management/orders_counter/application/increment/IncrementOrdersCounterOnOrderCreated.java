package es.antoniogo.management.orders_counter.application.increment;

import es.antoniogo.management.orders.domain.OrderCreatedDomainEvent;
import es.antoniogo.management.orders.domain.OrderId;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public final class IncrementOrdersCounterOnOrderCreated {
    private final OrdersCounterIncrementer incrementer;

    public IncrementOrdersCounterOnOrderCreated(OrdersCounterIncrementer incrementer) {
        this.incrementer = incrementer;
    }

    @EventListener
    public void on(OrderCreatedDomainEvent event) {
        OrderId courseId = new OrderId(event.aggregateId());

        incrementer.increment(courseId);
    }
}
