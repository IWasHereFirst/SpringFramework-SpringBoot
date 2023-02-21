package com.daniellesko.springboot101.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @PostMapping("/test/{name}")
    // Ziskanie Headeru z requestu do premennej
    public String test(@PathVariable("name") String name,
                       @RequestHeader String a,
                       @RequestHeader String b,
                       @RequestHeader String c,
                       @RequestBody String body,
                       HttpServletResponse response) {

        response.addHeader("Test", "good"); // pridanie Headeru
        return name + " " + a + " " + b + " " + c + " " + body;
    }

    // Ziskanie vsetkych headerov a odoslanie cez response body
    @GetMapping("/all")
    public Map<String, String> all(@RequestHeader Map<String, String> map) {
        return map;
    }

    // org.springframework.http.MediaType
    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file() {
        // nejako sa ziska a skonvertuje PDF do byte[]
        byte[] file = new byte[100];
        return file;
    }

}
