package com.andersonmarques.dao.interfaces;

import java.util.List;

import com.andersonmarques.domain.Funcionario;

public interface FuncionarioDao {

    void save(Funcionario entity);

    void update(Funcionario entity);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
    
}
