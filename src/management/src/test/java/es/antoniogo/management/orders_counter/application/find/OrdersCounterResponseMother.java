package es.antoniogo.management.orders_counter.application.find;

import es.antoniogo.shared.domain.IntegerMother;

public final class OrdersCounterResponseMother {
    public static OrdersCounterResponse create(Integer value) {
        return new OrdersCounterResponse(value);
    }

    public static OrdersCounterResponse random() {
        return create(IntegerMother.random());
    }
}
