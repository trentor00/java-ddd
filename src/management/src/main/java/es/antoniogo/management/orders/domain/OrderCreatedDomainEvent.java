package es.antoniogo.management.orders.domain;

import es.antoniogo.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class OrderCreatedDomainEvent extends DomainEvent<OrderCreatedDomainEvent> {
    private final String name;

    public OrderCreatedDomainEvent(String aggregateId, String name) {
        super(aggregateId);

        this.name = name;
    }

    public OrderCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name) {
        super(aggregateId, eventId, occurredOn);

        this.name = name;
    }

    @Override
    public String eventName() {
        return "order.created";
    }

    @Override
    protected HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
        }};
    }

    @Override
    protected OrderCreatedDomainEvent fromPrimitives(
            String aggregateId,
            HashMap<String, Serializable> body,
            String eventId,
            String occurredOn
    ) {
        return new OrderCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("name")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderCreatedDomainEvent that = (OrderCreatedDomainEvent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
