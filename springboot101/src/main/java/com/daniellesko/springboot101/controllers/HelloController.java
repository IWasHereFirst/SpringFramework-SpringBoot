package com.daniellesko.springboot101.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller     // mapuje dany endpoint s metodou, povoluje Servlet funkcionalitu
//@ResponseBody   // metody vracaju static body, takze nebude mapovat ich vysledky v
@RestController   // obsahuje @Controller a @ResponseBody
public class HelloController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)   // mapuje /index endpoint na tuto metodu
    //@ResponseBody     // nastavenim @ResponseBody nad metodou sa vypne mapovanie a metoda vrati to co je v return,
                        // nebude mapovat return "index.html" na resources/static/index.html, ale len zobrazi na stranke text index.html
    public String index(){
        System.out.println("index was accessed!");
        return "index.html";
    }

}
