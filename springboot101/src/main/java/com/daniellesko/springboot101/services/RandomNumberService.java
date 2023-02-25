package com.daniellesko.springboot101.services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@Service
// WebApplicationContext.SCOPE_REQUEST znamena, ze ked sa vola IndexController, tak @Autowired na tuto triedu neberie jej instanciu
// priamo z ApllicationContext, ale z Proxy, ktory spravuje ich instancie. Kazde volanie na IndexController vytvori v proxy
// novu instanciu pre bean RandomNumberService a injectne ju do IndexControlleru
// ScopedProxyMode.TARGET_CLASS znamena, ze sa vyuzije CGLib proxy, ktora podporuje spravu tried aj interface
// ScopedProxyMode.INTERFACES znamena, ze sa vyuzije JDK proxy, ktore podporuje len interface
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
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
