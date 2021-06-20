package es.antoniogo.management.orders_counter.domain;

import es.antoniogo.shared.domain.UuidMother;

public final class OrdersCounterIdMother {
    public static OrdersCounterId create(String value) {
        return new OrdersCounterId(value);
    }

    public static OrdersCounterId random() {
        return create(UuidMother.random());
    }
}
