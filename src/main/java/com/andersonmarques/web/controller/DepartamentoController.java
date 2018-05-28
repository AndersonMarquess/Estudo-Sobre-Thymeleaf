package com.andersonmarques.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    /*@GetMapping("/cadastrar")*/
    @RequestMapping(method = RequestMethod.GET, path = "/cadastrar")
    public String cadastrar() {
        //Ele procura no package resources>templates o pacote "departamento">"cadastro.html"
        return "/departamento/cadastro";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listar")
    public String listar() {
        return "/departamento/lista";
    }
}
