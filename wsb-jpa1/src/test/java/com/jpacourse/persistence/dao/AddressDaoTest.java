package com.jpacourse.persistence.dao;

import com.jpacourse.persistence.entity.AddressEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AddressDaoTest {

    @Autowired
    private AddressDao addressDao;

    @Transactional
    @Test
    public void testShouldFindAddressById() {
        // given
        AddressEntity newAddress = new AddressEntity();
        newAddress.setAddressLine1("Nowa");
        newAddress.setAddressLine2("Test");
        newAddress.setCity("Wrocław");
        newAddress.setPostalCode("60-400");
        AddressEntity saved = addressDao.save(newAddress);

        // when
        AddressEntity found = addressDao.findById(saved.getId()).orElse(null);

        // then
        assertThat(found).isNotNull();
        assertThat(found.getPostalCode()).isEqualTo("60-400");
    }

    @Transactional
    @Test
    public void testShouldSaveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");
        long entitiesNumBefore = addressDao.count();

        // when
        AddressEntity saved = addressDao.save(addressEntity);

        // then
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
        assertThat(addressDao.count()).isEqualTo(entitiesNumBefore + 1);
    }

    @Transactional
    @Test
    public void testShouldSaveAndRemoveAddress() {
        // given
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setAddressLine1("line1");
        addressEntity.setAddressLine2("line2");
        addressEntity.setCity("City1");
        addressEntity.setPostalCode("66-666");

        // when
        AddressEntity saved = addressDao.save(addressEntity);
        assertThat(saved.getId()).isNotNull();

        AddressEntity found = addressDao.findById(saved.getId()).orElse(null);
        assertThat(found).isNotNull();

        addressDao.delete(saved);

        // then
        AddressEntity afterDelete = addressDao.findById(saved.getId()).orElse(null);
        assertThat(afterDelete).isNull();
    }
}
