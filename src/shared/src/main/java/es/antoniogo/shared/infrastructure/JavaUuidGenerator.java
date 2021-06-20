package es.antoniogo.shared.infrastructure;

import es.antoniogo.shared.domain.UuidGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JavaUuidGenerator implements UuidGenerator {
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
