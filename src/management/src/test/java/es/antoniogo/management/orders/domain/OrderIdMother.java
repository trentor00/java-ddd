package es.antoniogo.management.orders.domain;

import es.antoniogo.shared.domain.UuidMother;

public final class OrderIdMother {
    public static OrderId create(String value) {
        return new OrderId(value);
    }

    public static OrderId random() {
        return create(UuidMother.random());
    }
}
