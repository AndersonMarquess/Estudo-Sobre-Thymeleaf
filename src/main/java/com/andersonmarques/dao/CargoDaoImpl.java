package com.andersonmarques.dao;

import com.andersonmarques.dao.interfaces.CargoDao;
import com.andersonmarques.domain.Cargo;
import org.springframework.stereotype.Repository;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
}
