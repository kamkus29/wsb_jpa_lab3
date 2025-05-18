package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.DoctorEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDao implements Dao<DoctorEntity, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public DoctorEntity save(DoctorEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public DoctorEntity getOne(Long id) {
        return entityManager.getReference(DoctorEntity.class, id);
    }

    @Override
    public DoctorEntity findOne(Long id) {
        return entityManager.find(DoctorEntity.class, id);
    }

    @Override
    public List<DoctorEntity> findAll() {
        return entityManager.createQuery("FROM DoctorEntity", DoctorEntity.class).getResultList();
    }

    @Override
    public DoctorEntity update(DoctorEntity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(DoctorEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void delete(Long id) {
        DoctorEntity entity = findOne(id);
        if (entity != null) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM DoctorEntity").executeUpdate();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(d) FROM DoctorEntity d", Long.class).getSingleResult();
    }

    @Override
    public boolean exists(Long id) {
        return findOne(id) != null;
    }
}
