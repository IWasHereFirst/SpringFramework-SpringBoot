package com.daniellesko.springboot101.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

// Pridanie parametru do health/ endpointu
@Component
public class MyCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("abc", "myval").build();
    }
}
