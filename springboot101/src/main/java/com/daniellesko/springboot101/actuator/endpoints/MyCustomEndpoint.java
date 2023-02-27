package com.daniellesko.springboot101.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

// Vytvorenie vlastneho endpointu
@Component
@Endpoint(id = "myEndpoint")
public class MyCustomEndpoint {

    // Dostupne operacie: @ReadOperation, @WriteOperation, @DeleteOperation
    // podla toho je potrebne pouzit GET, POST...
    @ReadOperation
    public String test() {
        return ":)";
    }

}
