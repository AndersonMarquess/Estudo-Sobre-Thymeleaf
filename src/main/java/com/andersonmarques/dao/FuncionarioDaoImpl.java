package com.andersonmarques.dao;

import com.andersonmarques.dao.interfaces.FuncionarioDao;
import com.andersonmarques.domain.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

    @Override
    public List<Funcionario> findByNome(String nome) {

        //select * from FUNCIONARIOS where nome like = ?
//        TypedQuery<Funcionario> query = getEntityManager()
//                .createQuery("select f from Funcionario f where f.nome like :nome% ", Funcionario.class);
//        query.setParameter("nome", nome);
//        return query.getResultList();

        /*OU*/
        return createQuery("select f from Funcionario f where f.nome like concat('%', ?1, '%') ", nome);
    }
}
