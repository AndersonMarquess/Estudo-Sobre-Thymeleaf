package com.andersonmarques.dao.interfaces;

import com.andersonmarques.domain.Departamento;

import java.util.List;

public interface DepartamentoDao {


    void save(Departamento entity);

    void update(Departamento entity);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
    
}
