package com.andersonmarques.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.andersonmarques.domain.Departamento;
import com.andersonmarques.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService service;

    /*@GetMapping("/cadastrar")*/
    @RequestMapping(method = RequestMethod.GET, path = "/cadastrar")
    public String cadastrar(Departamento departamento) {
        //Ele procura no package resources>templates o pacote "departamento">"cadastro.html"
        return "/departamento/cadastro";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/listar")
    public String listar(ModelMap model) {
        //O nome departamentos é o especificado na página HTML
        model.addAttribute("departamentos", service.buscarTodos());
        return "/departamento/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento) {
        service.salvar(departamento);
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        //ModelMap permite evitar a variavel como objeto para página de cadastro
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Departamento departamento) {
        service.editar(departamento);
        return "redirect:/departamentos/cadastrar";
    }
}
