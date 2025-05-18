package com.jpacourse.persistence.dao.jpql;

import com.jpacourse.persistence.entity.PatientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientJpqlDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<PatientEntity> findByLastName(String lastName) {
        return entityManager.createQuery(
                        "SELECT p FROM PatientEntity p WHERE p.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    public List<PatientEntity> findPatientsWithMoreThanXVisits(long numberOfVisits) {
        return entityManager.createQuery(
                        "SELECT DISTINCT p FROM PatientEntity p JOIN FETCH p.visits WHERE SIZE(p.visits) > :visitCount",
                        PatientEntity.class)
                .setParameter("visitCount", numberOfVisits)
                .getResultList();
    }
}
