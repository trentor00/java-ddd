package es.antoniogo.management.orders.domain;

public final class OrderCreatedDomainEventMother {
    public static OrderCreatedDomainEvent create(OrderId id, OrderName name) {
        return new OrderCreatedDomainEvent(id.value(), name.value());
    }

    public static OrderCreatedDomainEvent fromOrder(Order order) {
        return create(order.id(), order.name());
    }

    public static OrderCreatedDomainEvent random() {
        return create(OrderIdMother.random(), OrderNameMother.random());
    }
}
