package es.antoniogo.management.orders.domain;

import es.antoniogo.shared.domain.AggregateRoot;

import java.util.Objects;

public final class Order extends AggregateRoot {
    private final OrderId id;
    private final OrderName name;

    public Order(OrderId id, OrderName name) {
        this.id = id;
        this.name = name;
    }

    private Order() {
        id = null;
        name = null;
    }

    public static Order create(OrderId id, OrderName name) {
        Order order = new Order(id, name);

        order.record(new OrderCreatedDomainEvent(id.value(), name.value()));

        return order;
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
