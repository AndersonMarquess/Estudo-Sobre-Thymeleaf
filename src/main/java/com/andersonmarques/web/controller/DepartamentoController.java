package com.andersonmarques.web.controller;

import com.andersonmarques.domain.Departamento;
import com.andersonmarques.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
    //@Valid é usado para informar que precisa validar via bean validation, O Binding result é responsável por verificar se as validações foram atendidas
    public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()) {
            return "/departamento/cadastro";
        }

        service.salvar(departamento);
        attr.addFlashAttribute("success", "Departamento inserido com sucesso!");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        //ModelMap permite enviar a variável como objeto para página de cadastro
        model.addAttribute("departamento", service.buscarPorId(id));
        return "/departamento/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
        if(result.hasErrors()) {
            return "/departamento/cadastro";
        }

        service.editar(departamento);
        attr.addFlashAttribute("success", "Departamento editado com sucesso!");
        return "redirect:/departamentos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (service.departamentoTemCargos(id)) {
            model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
        } else {
            model.addAttribute("success", "Departamento removido com sucesso!");
            service.excluir(id);
        }

        return listar(model);
    }
}
