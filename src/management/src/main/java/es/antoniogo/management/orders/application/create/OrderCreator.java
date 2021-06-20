package es.antoniogo.management.orders.application.create;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderName;
import es.antoniogo.management.orders.domain.OrderRepository;
import es.antoniogo.shared.domain.bus.event.EventBus;
import org.springframework.stereotype.Service;

@Service
public final class OrderCreator {
    private OrderRepository repository;
    private final EventBus eventBus;

    public OrderCreator(OrderRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(CreateOrderRequest request) {
        OrderId id = new OrderId(request.id());
        OrderName name = new OrderName(request.name());

        Order order = Order.create(id, name);

        repository.save(order);
        eventBus.publish(order.pullDomainEvents());
    }
}
