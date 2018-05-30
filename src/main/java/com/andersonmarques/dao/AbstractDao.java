package com.andersonmarques.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


public abstract class AbstractDao <TipoGenerico, Tipo_PK_generico extends Serializable> {

    @SuppressWarnings("unchecked")
    private final Class<TipoGenerico>  entityClass = (Class<TipoGenerico>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(TipoGenerico entity) {
        entityManager.persist(entity);
    }

    public void update(TipoGenerico entity) {
        entityManager.merge(entity);
    }

    public void delete(Tipo_PK_generico id) {
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public TipoGenerico findById(Tipo_PK_generico id) {
        return entityManager.find(entityClass, id);
    }

    public List<TipoGenerico> findAll() {
        return entityManager.createQuery("from "+entityClass.getSimpleName(), entityClass).getResultList();
    }

    protected List<TipoGenerico> createQuery(String jpql, Object[] params) {
        TypedQuery<TipoGenerico> query = entityManager.createQuery(jpql, entityClass);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i+1, params[i]);
        }
        return query.getResultList();
    }
}
