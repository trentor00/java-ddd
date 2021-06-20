package es.antoniogo.apps.management.controller.orders;

import es.antoniogo.apps.management.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public final class OrdersPutControllerTest extends ApplicationTestCase {
    @Test
    void create_a_valid_order() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/orders/"+ UUID.randomUUID().toString(),
                "{\"name\": \"The best order\"}",
                201
        );
    }
}
