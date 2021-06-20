package es.antoniogo.management.orders_counter.application.find;

import java.util.Objects;

public final class OrdersCounterResponse {
    private Integer total;

    public OrdersCounterResponse(Integer total) {
        this.total = total;
    }

    public Integer total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersCounterResponse that = (OrdersCounterResponse) o;
        return Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
