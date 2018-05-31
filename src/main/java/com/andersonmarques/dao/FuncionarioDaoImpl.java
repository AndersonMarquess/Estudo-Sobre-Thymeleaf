package com.andersonmarques.dao;

import com.andersonmarques.dao.interfaces.FuncionarioDao;
import com.andersonmarques.domain.Funcionario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    @Override
    public List<Funcionario> findByCargoId(Long id) {
        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }

    @Override
    public List<Funcionario> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
        String jpql = "select f from Funcionario f " +
                    "where f.dataEntrada >= ?1 and f.dataSaida <= ?2 " +
                    "order by f.dataEntrada asc";

        return createQuery(jpql, entrada, saida);
    }

    @Override
    public List<Funcionario> findByDataEntrada(LocalDate entrada) {
        String jpql = "select f from Funcionario f " +
                "where f.dataEntrada = ?1 order by f.dataEntrada asc";

        return createQuery(jpql, entrada);
    }

    @Override
    public List<Funcionario> findByDataSaida(LocalDate saida) {
        String jpql = "select f from Funcionario f " +
                "where f.dataSaida = ?1 order by f.dataEntrada asc";

        return createQuery(jpql, saida);
    }
}
