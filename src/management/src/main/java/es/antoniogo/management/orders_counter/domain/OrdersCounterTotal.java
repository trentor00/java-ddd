package es.antoniogo.management.orders_counter.domain;

import es.antoniogo.shared.domain.IntValueObject;

public final class OrdersCounterTotal extends IntValueObject {
    public OrdersCounterTotal(Integer value) {
        super(value);
    }

    public OrdersCounterTotal() {
        super(null);
    }

    public static OrdersCounterTotal initialize() {
        return new OrdersCounterTotal(0);
    }

    public OrdersCounterTotal increment() {
        return new OrdersCounterTotal(value() + 1);
    }
}
