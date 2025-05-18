package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Long> {
}
