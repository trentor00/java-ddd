package es.antoniogo.apps.management.controller.orders_counter;

import es.antoniogo.management.orders_counter.application.find.OrdersCounterFinder;
import es.antoniogo.management.orders_counter.application.find.OrdersCounterResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public final class OrdersCounterGetController {
    OrdersCounterFinder finder;

    public OrdersCounterGetController(OrdersCounterFinder finder){
        this.finder = finder;
    }

    @GetMapping("/orders-counter")
    public HashMap<String, Integer> index() {
        OrdersCounterResponse response = finder.find();

        return new HashMap<String, Integer>() {{
           put("total", response.total());
        }};
    }
}
