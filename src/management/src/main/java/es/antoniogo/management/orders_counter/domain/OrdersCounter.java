package es.antoniogo.management.orders_counter.domain;

import es.antoniogo.management.orders.domain.OrderId;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class OrdersCounter {
    private OrdersCounterId    id;
    private OrdersCounterTotal total;
    private List<OrderId> existingOrders;

    public OrdersCounter(OrdersCounterId id, OrdersCounterTotal total, List<OrderId> existingOrders) {
        this.id              = id;
        this.total           = total;
        this.existingOrders = existingOrders;
    }

    private OrdersCounter() {
        this.id              = null;
        this.total           = null;
        this.existingOrders = null;
    }

    public OrdersCounterId id() {
        return id;
    }

    public OrdersCounterTotal total() {
        return total;
    }

    public List<OrderId> existingOrders() {
        return existingOrders;
    }

    public static OrdersCounter initialize(String id) {
        return new OrdersCounter(new OrdersCounterId(id), OrdersCounterTotal.initialize(), new ArrayList<>());
    }

    public boolean hasIncremented(OrderId id) {
        return existingOrders.contains(id);
    }

    public void increment(OrderId id) {
        total = total.increment();
        existingOrders.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersCounter that = (OrdersCounter) o;
        return Objects.equals(id, that.id) && Objects.equals(total, that.total) && Objects.equals(existingOrders, that.existingOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingOrders);
    }
}
