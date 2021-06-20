package es.antoniogo.management.orders_counter.application.increment;

import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterRepository;
import es.antoniogo.shared.domain.UuidGenerator;
import org.springframework.stereotype.Service;

@Service
public final class OrdersCounterIncrementer {
    private OrdersCounterRepository repository;
    private UuidGenerator uuidGenerator;

    public OrdersCounterIncrementer(OrdersCounterRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(OrderId id) {
        OrdersCounter counter = repository.search()
                .orElseGet(() -> OrdersCounter.initialize(uuidGenerator.generate()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);

            repository.save(counter);
        }
    }
}
