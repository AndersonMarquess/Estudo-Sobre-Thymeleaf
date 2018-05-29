package com.andersonmarques.dao;

import com.andersonmarques.dao.interfaces.DepartamentoDao;
import com.andersonmarques.domain.Departamento;
import org.springframework.stereotype.Repository;

@Repository
public class DepartamentoDaoImpl extends AbstractDao<Departamento, Long> implements DepartamentoDao {


}
