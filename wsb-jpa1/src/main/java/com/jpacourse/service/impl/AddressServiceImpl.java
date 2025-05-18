package com.jpacourse.service.impl;

import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.service.AddressService;
import com.jpacourse.mapper.AddressMapper;
import com.jpacourse.service.to.AddressTo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;
    private final AddressMapper addressMapper;

    public AddressServiceImpl(AddressDao addressDao, AddressMapper addressMapper) {
        this.addressDao = addressDao;
        this.addressMapper = addressMapper;
    }

    @Override
    public List<AddressTo> findAll() {
        return addressDao.findAll()
                .stream()
                .map(addressMapper::mapToTo)
                .collect(Collectors.toList());
    }

    @Override
    public AddressTo findById(Long id) {
        return addressMapper.mapToTo(addressDao.findById(id).orElse(null));
    }

    @Override
    public AddressTo save(AddressTo address) {
        AddressEntity entity = addressMapper.mapToEntity(address);
        AddressEntity saved = addressDao.save(entity);
        return addressMapper.mapToTo(saved);
    }

    @Override
    public void deleteById(Long id) {
        addressDao.deleteById(id);
    }

    @Override
    public void delete(Long id) {
        deleteById(id);
    }

}

