package es.antoniogo.management.orders_counter.domain;

import es.antoniogo.shared.domain.IntegerMother;

public class OrdersCounterTotalMother {
    public static OrdersCounterTotal create(Integer value) {
        return new OrdersCounterTotal(value);
    }

    public static OrdersCounterTotal random() {
        return create(IntegerMother.random());
    }

    public static OrdersCounterTotal one() {
        return create(1);
    }
}
