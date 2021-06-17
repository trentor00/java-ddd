package es.antoniogo.management.orders.application.create;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderName;
import es.antoniogo.management.orders.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public final class OrderCreator {
    private OrderRepository repository;

    public OrderCreator(OrderRepository repository) {
        this.repository = repository;
    }

    public void create(CreateOrderRequest request) {
        Order order = new Order(new OrderId(request.id()), new OrderName(request.name()));

        repository.save(order);
    }
}
