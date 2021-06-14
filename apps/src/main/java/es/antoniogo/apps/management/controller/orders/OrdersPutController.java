package es.antoniogo.apps.management.controller.orders;

import es.antoniogo.management.orders.application.create.OrderCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class OrdersPutController {
    private OrderCreator creator;

    public OrdersPutController(OrderCreator creator) {
        this.creator = creator;
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<?> create(@PathVariable String id, @RequestBody Request request) {
        creator.create(id, request.name());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;

    String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
