package com.andersonmarques.dao;

import org.springframework.stereotype.Repository;

import com.andersonmarques.dao.interfaces.CargoDao;
import com.andersonmarques.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
}
