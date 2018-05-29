package com.andersonmarques.dao.interfaces;

import com.andersonmarques.domain.Cargo;

import java.util.List;

public interface CargoDao {
    void save(Cargo entity);

    void update(Cargo entity);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
}
