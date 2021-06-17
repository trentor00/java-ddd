package es.antoniogo.management.orders.infrastructure;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public final class InMemoryOrderRepository implements OrderRepository {
    private HashMap<OrderId, Order> orders = new HashMap<>();

    @Override
    public void save(Order order) {
        this.orders.put(order.id(), order);
    }

    @Override
    public Optional<Order> search(OrderId id) {
        return Optional.ofNullable(orders.get(id));
    }
}
