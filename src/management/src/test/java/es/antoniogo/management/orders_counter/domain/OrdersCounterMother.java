package es.antoniogo.management.orders_counter.domain;

import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderIdMother;
import es.antoniogo.shared.domain.ListMother;

import java.util.ArrayList;
import java.util.List;

public final class OrdersCounterMother {
    public static OrdersCounter create(
            OrdersCounterId id,
            OrdersCounterTotal total,
            List<OrderId> existingOrders
    ) {
        return new OrdersCounter(id, total, existingOrders);
    }

    public static OrdersCounter withOne(OrderId orderId) {
        return create(OrdersCounterIdMother.random(), OrdersCounterTotalMother.one(), ListMother.one(orderId));
    }

    public static OrdersCounter random() {
        List<OrderId> existingOrders = ListMother.random(OrderIdMother::random);

        return create(
                OrdersCounterIdMother.random(),
                OrdersCounterTotalMother.create(existingOrders.size()),
                existingOrders
        );
    }

    public static OrdersCounter incrementing(OrdersCounter existingCounter, OrderId orderId) {
        List<OrderId> existingOrders = new ArrayList<>(existingCounter.existingOrders());
        existingOrders.add(orderId);

        return create(
                existingCounter.id(),
                OrdersCounterTotalMother.create(existingCounter.total().value() + 1),
                existingOrders
        );
    }
}
