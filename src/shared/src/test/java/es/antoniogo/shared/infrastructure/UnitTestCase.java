package es.antoniogo.shared.infrastructure;

import es.antoniogo.shared.domain.UuidGenerator;
import es.antoniogo.shared.domain.bus.event.DomainEvent;
import es.antoniogo.shared.domain.bus.event.EventBus;
import org.junit.jupiter.api.BeforeEach;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public abstract class UnitTestCase {
    protected EventBus eventBus;
    protected UuidGenerator uuidGenerator;

    @BeforeEach
    protected void setUp() {
        eventBus = mock(EventBus.class);
        uuidGenerator = mock(UuidGenerator.class);
    }

    public void shouldHavePublished(List<DomainEvent<?>> domainEvents) {
        verify(eventBus, atLeastOnce()).publish(domainEvents);
    }

    public void shouldHavePublished(DomainEvent<?> domainEvent) {
        shouldHavePublished(Collections.singletonList(domainEvent));
    }

    public void shouldGenerateUuid(String uuid) {
        when(uuidGenerator.generate()).thenReturn(uuid);
    }
}
