package com.andersonmarques.service;

import com.andersonmarques.domain.Departamento;

import java.util.List;

public interface DepartamentoService {

    void salvar(Departamento cargo);

    void editar(Departamento cargo);

    void excluir(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarTodos();

    boolean departamentoTemCargos(Long id);

}
