package com.andersonmarques.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//Não é RestController
@Controller
public class HomeController {

    //O GetMapping funciona como o method=RequestMethod.GET
    //@RequestMapping(method = RequestMethod.GET, path = "/")
    @GetMapping("/")
    public String home() {
        //Quando for feito o get no "localhost:8081/" será retornado o /home.html, não é preciso colocar .html
        return "/home";
    }
}
