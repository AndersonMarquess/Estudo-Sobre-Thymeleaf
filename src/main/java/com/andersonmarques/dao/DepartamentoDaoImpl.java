package com.andersonmarques.dao;

import org.springframework.stereotype.Repository;

import com.andersonmarques.dao.interfaces.DepartamentoDao;
import com.andersonmarques.domain.Departamento;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {
}
