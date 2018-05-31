package com.andersonmarques.dao.interfaces;

import com.andersonmarques.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void save(Funcionario entity);

    void update(Funcionario entity);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargoId(Long id);
}
