package com.andersonmarques.web.controller;

import com.andersonmarques.domain.Cargo;
import com.andersonmarques.domain.Departamento;
import com.andersonmarques.service.CargoService;
import com.andersonmarques.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/cargos")
public class CargosController {

    @Autowired
    private CargoService cargoService;
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Cargo cargo) {
        return "/cargo/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        //Satisfaz a foreach da lista.html com a lista de nome cargos
        model.addAttribute("cargos", cargoService.buscarTodos());
        return "/cargo/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Cargo cargo, RedirectAttributes attr) {
        cargoService.salvar(cargo);
        attr.addFlashAttribute("success", "Cargo inserido com sucesso!");
        return "redirect:/cargos/cadastrar";
    }

    @ModelAttribute("departamentos")
    public List<Departamento> listaDeDepartamentos() {
        return departamentoService.buscarTodos();
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("cargo", cargoService.buscarPorId(id));
        return "cargo/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Cargo cargo, RedirectAttributes attr) {
        cargoService.editar(cargo);
        attr.addFlashAttribute("success", "Registro atualizado com sucesso!");
        return "redirect:/cargos/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (cargoService.cargoTemFuncionarios(id)) {
            attr.addFlashAttribute("fail", "Cargo não excluido. Existe(m) funcionario(s) vinculado(s).");
        } else {
            cargoService.excluir(id);
            attr.addFlashAttribute("success", "Cargo excluido com sucesso!");
        }
        return "redirect:/cargos/listar";
    }
}
