package es.antoniogo.management.orders.domain;

import java.util.Objects;

public final class Order {
    private final OrderId id;
    private final OrderName name;

    public Order(OrderId id, OrderName name) {
        this.id = id;
        this.name = name;
    }

    private Order() {
        this(null, null);
    }

    public OrderId id() {
        return id;
    }

    public OrderName name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
