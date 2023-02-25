package com.daniellesko.springboot101.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
// WebApplicationContext.SCOPE_SESSION - vytvori serverside session vytvorenim cookie, ktora existuje po dobu 25min.
// Je mozne session nakonfigurovat v application.properties. Reprezentuje Statefull data na servery (zle pre skalovatelnost aplikacie)
// Proxy vytvori instanciu pre kazdy session.
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.INTERFACES)
public class RandomNumberService implements MyService {
    private final int value;

    public RandomNumberService() {
        this.value = new Random().nextInt(1000);
    }

    public int getValue() {
        new RuntimeException().printStackTrace();
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
