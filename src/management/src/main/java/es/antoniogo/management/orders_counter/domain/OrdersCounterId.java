package es.antoniogo.management.orders_counter.domain;

import es.antoniogo.shared.domain.Identifier;

public final class OrdersCounterId extends Identifier {
    public OrdersCounterId(String value) {
        super(value);
    }

    private OrdersCounterId() {
    }
}
