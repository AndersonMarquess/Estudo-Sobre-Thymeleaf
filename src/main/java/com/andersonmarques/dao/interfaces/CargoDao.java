package com.andersonmarques.dao.interfaces;

import java.util.List;

import com.andersonmarques.domain.Cargo;


public interface CargoDao {
    void save(Cargo entity);

    void update(Cargo entity);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
