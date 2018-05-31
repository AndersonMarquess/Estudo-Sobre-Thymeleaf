package com.andersonmarques.service;

import com.andersonmarques.domain.Funcionario;

import java.util.List;

public interface FuncionarioService {

    void salvar(Funcionario cargo);

    void editar(Funcionario cargo);

    void excluir(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();

    List<Funcionario> buscarPorNome(String nome);

    List<Funcionario> buscarPorCargo(Long id);
}
