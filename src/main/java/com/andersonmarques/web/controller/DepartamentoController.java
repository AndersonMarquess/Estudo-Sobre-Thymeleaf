package com.andersonmarques.web.controller;

import com.andersonmarques.domain.Departamento;
import com.andersonmarques.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

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

    @PostMapping("/salvar")
    public String salvar(Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }
}
