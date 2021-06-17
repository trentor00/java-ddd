package es.antoniogo.management.orders.domain;

import java.util.Optional;

public interface OrderRepository {
    public void save(Order order);
    Optional<Order> search(OrderId id);
}
