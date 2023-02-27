package com.daniellesko.springboot101.actuator.extensions;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

// Modifikacia /info endpointu
@Component
@EndpointWebExtension(endpoint = InfoEndpoint.class)
public class InfoEndpointWebExtension {

    // Kedze sa jedna o WebEndpointy (zobrazene cez web rozhranie), tak sa vracia WebEndpointResponse<Object>
    @ReadOperation
    public WebEndpointResponse<String> info(){
        return new WebEndpointResponse<>("new web info response");
    }
}
