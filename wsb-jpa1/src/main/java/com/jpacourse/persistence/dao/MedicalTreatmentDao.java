package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalTreatmentDao implements Dao<MedicalTreatmentEntity, Long> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public MedicalTreatmentEntity save(MedicalTreatmentEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public MedicalTreatmentEntity getOne(Long id) {
        return entityManager.getReference(MedicalTreatmentEntity.class, id);
    }

    @Override
    public MedicalTreatmentEntity findOne(Long id) {
        return entityManager.find(MedicalTreatmentEntity.class, id);
    }

    @Override
    public List<MedicalTreatmentEntity> findAll() {
        return entityManager.createQuery("FROM MedicalTreatmentEntity", MedicalTreatmentEntity.class).getResultList();
    }

    @Override
    public MedicalTreatmentEntity update(MedicalTreatmentEntity entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(MedicalTreatmentEntity entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void delete(Long id) {
        MedicalTreatmentEntity entity = findOne(id);
        if (entity != null) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM MedicalTreatmentEntity").executeUpdate();
    }

    @Override
    public long count() {
        return entityManager.createQuery("SELECT COUNT(m) FROM MedicalTreatmentEntity m", Long.class).getSingleResult();
    }

    @Override
    public boolean exists(Long id) {
        return findOne(id) != null;
    }
}
