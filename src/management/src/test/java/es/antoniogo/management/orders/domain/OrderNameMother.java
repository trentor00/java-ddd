package es.antoniogo.management.orders.domain;

import es.antoniogo.shared.domain.WordMother;

public final class OrderNameMother {
    public static OrderName create(String value) {
        return new OrderName(value);
    }

    public static OrderName random() {
        return create(WordMother.random());
    }
}
