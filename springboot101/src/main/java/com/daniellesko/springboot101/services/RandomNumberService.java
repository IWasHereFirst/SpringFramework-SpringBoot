package com.daniellesko.springboot101.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
// WebApplicationContext.SCOPE_SESSION - funguje ako singleton, nie teda potrebne pridavat proxy
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
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
