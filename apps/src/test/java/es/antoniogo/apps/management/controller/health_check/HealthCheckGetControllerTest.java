package es.antoniogo.apps.management.controller.health_check;

import es.antoniogo.apps.management.controller.ApplicationTestCase;
import org.junit.jupiter.api.Test;

final class HealthCheckGetControllerTest extends ApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}