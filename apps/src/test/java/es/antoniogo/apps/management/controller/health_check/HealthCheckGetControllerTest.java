package es.antoniogo.apps.management.controller.health_check;

import es.antoniogo.apps.management.controller.RequestTestCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class HealthCheckGetControllerTest extends RequestTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}