package com.daniellesko.springboot101.controllers;

import com.daniellesko.springboot101.dto.Person;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController // vyuziva @Controller a @ResponseBody
public class HelloController {


    //@RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")   // to iste skratenym zapisom nizsie
    @GetMapping("/hello/{name}") // GetMapping s endpointom /hello a parametrom(premennou) {name}
    public String Hello(@PathVariable("name") String name) {    // @PathVariable ziska premennu z parametru v endpointe a vlozi do premennej name
        return "Hello " + name + "!";   // vrati uzivatelovi ako ResponseBody
    }

    // Na endpointe su v body requestu nejake informacie zadane napr. v Postmanovi, neskor cez @RequestBody su priradene do premennej Person
    // Server spracuje udaje v Person a vrati ich hodnotu (preto, ze sa nieco vracia sa neda pouzit GetMapping)
    @PostMapping("/goodbye")
    public String goodbye(@RequestBody Person person) { // ziskanie body dat pomocou @RequestBody a vlozenie tychto dat do Person
        return "Goodbye " + person.getName() + "!";
    }

    // Na endpointe /getperson sa vrati zo serveru objekt Bill, ktory je parsovany a uzivatel ho vidi ako JSON
    @GetMapping("/getperson")
    public Person getPerson() {
        Person p = new Person();
        p.setName("Bill");
        return p;
    }

    // Je mozne vratit aj Collection
    @GetMapping("/getall")
    public List<Person> getAllPersons() {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("Bill");
        p2.setName("Phill");
        return Arrays.asList(p1, p2);
    }

    // Vratenie statusu a zaroven aj objektu
    @GetMapping("/statustest")
    public Person statusTest(HttpServletResponse response){
        // Nastavenie HttpResponse na 201, tato hodnota bude vratena klientovi zo serveru
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        // Je stale mozne vratit aj objekt
        Person p1 = new Person();
        p1.setName("Bill");
        return p1;
    }


}
