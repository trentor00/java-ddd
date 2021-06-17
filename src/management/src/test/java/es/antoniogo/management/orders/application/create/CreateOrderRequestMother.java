package es.antoniogo.management.orders.application.create;

import es.antoniogo.management.orders.domain.*;

public final class CreateOrderRequestMother {
    public static CreateOrderRequest create(OrderId id, OrderName name) {
        return new CreateOrderRequest(id.value(), name.value());
    }

    public static CreateOrderRequest random() {
        return create(OrderIdMother.random(), OrderNameMother.random());
    }
}
