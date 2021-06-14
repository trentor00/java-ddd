package es.antoniogo.apps.management.controller.orders;

import es.antoniogo.apps.management.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

public final class OrdersPutControllerTest extends RequestTestCase {
    @Test
    void create_a_valid_order() throws Exception {
        assertRequestWithBody(
                "PUT",
                "/orders/1aab45ba-3c7a-4344-8936-78466eca77fa",
                "{\"name\": \"The best order\"}",
                201
        );
    }
}
