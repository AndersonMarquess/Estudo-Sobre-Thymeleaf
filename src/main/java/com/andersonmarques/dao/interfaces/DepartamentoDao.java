package com.andersonmarques.dao.interfaces;

import java.util.List;

import com.andersonmarques.domain.Departamento;

public interface DepartamentoDao {


    void save(Departamento entity);

    void update(Departamento entity);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
    
}
