package com.andersonmarques.dao;

import com.andersonmarques.dao.interfaces.FuncionarioDao;
import com.andersonmarques.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
}
