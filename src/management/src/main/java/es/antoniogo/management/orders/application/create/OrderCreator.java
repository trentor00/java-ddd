package es.antoniogo.management.orders.application.create;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public final class OrderCreator {
    private OrderRepository repository;

    public OrderCreator(OrderRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name) {
        Order order = new Order(id, name);

        repository.save(order);
    }
}
