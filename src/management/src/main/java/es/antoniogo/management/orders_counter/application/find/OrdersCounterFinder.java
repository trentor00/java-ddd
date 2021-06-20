package es.antoniogo.management.orders_counter.application.find;

import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterNotInitialized;
import es.antoniogo.management.orders_counter.domain.OrdersCounterRepository;
import org.springframework.stereotype.Service;

@Service
public final class OrdersCounterFinder {
    private OrdersCounterRepository repository;

    public OrdersCounterFinder(OrdersCounterRepository repository) {
        this.repository = repository;
    }

    public OrdersCounterResponse find() {
        OrdersCounter ordersCounter = repository.search().orElseGet(() -> {
            throw new OrdersCounterNotInitialized();
        });

        return new OrdersCounterResponse(ordersCounter.total().value());
    }
}
