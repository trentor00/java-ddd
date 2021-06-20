package es.antoniogo.management.orders_counter.infrastructure.persistence;

import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterRepository;
import es.antoniogo.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class MySqlOrdersCounterRepository extends HibernateRepository<OrdersCounter> implements OrdersCounterRepository {
    public MySqlOrdersCounterRepository(SessionFactory sessionFactory) {
        super(sessionFactory, OrdersCounter.class);
    }

    @Override
    public void save(OrdersCounter counter) {
        persist(counter);
    }

    @Override
    public Optional<OrdersCounter> search() {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<OrdersCounter> criteria = builder.createQuery(aggregateClass);
        criteria.from(aggregateClass);
        List<OrdersCounter> ordersCounter = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();

        return 0 == ordersCounter.size() ? Optional.empty() : Optional.ofNullable(ordersCounter.get(0));
    }
}
