package es.antoniogo.management.orders_counter;

import es.antoniogo.management.orders_counter.domain.OrdersCounter;
import es.antoniogo.management.orders_counter.domain.OrdersCounterRepository;
import es.antoniogo.shared.infrastructure.UnitTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class OrdersCounterModuleUnitTestCase extends UnitTestCase {
    protected OrdersCounterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(OrdersCounterRepository.class);
    }

    public void shouldSearch(OrdersCounter counter) {
        Mockito.when(repository.search()).thenReturn(Optional.of(counter));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(OrdersCounter counter) {
        verify(repository, atLeastOnce()).save(counter);
    }
}
