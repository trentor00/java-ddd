package es.antoniogo.management.orders.domain;

import es.antoniogo.management.orders.application.create.CreateOrderRequest;

public final class OrderMother {
    public static Order create(OrderId id, OrderName name) {
        return new Order(id, name);
    }

    public static Order fromRequest(CreateOrderRequest request) {
        return create(
                OrderIdMother.create(request.id()),
                OrderNameMother.create(request.name())
        );
    }

    public static Order random() {
        return create(OrderIdMother.random(), OrderNameMother.random());
    }
}
