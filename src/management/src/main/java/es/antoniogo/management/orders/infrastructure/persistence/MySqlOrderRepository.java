package es.antoniogo.management.orders.infrastructure.persistence;

import es.antoniogo.management.orders.domain.Order;
import es.antoniogo.management.orders.domain.OrderId;
import es.antoniogo.management.orders.domain.OrderRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Primary
@Repository
public class MySqlOrderRepository implements OrderRepository {
    private SessionFactory sessionFactory;

    public MySqlOrderRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Optional<Order> search(OrderId id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Order.class, id));
    }
}
