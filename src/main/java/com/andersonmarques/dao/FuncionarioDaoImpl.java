package com.andersonmarques.dao;

import org.springframework.stereotype.Repository;

import com.andersonmarques.dao.interfaces.FuncionarioDao;
import com.andersonmarques.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
}
