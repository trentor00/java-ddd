package es.antoniogo.management.orders.infrastructure.persistence;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderRepository;
import es.antoniogo.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public class MySqlOrderRepository extends HibernateRepository<Order> implements OrderRepository {
    private SessionFactory sessionFactory;

    public MySqlOrderRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Order.class);
    }

    @Override
    public void save(Order order) {
        persist(order);
    }

    @Override
    public Optional<Order> search(OrderId id) {
        return byId(id);
    }
}
