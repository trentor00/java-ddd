package es.antoniogo.management.orders_counter.domain;

import java.util.Optional;

public interface OrdersCounterRepository {
    void save(OrdersCounter counter);

    Optional<OrdersCounter> search();
}
