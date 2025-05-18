package com.jpacourse.service;

import com.jpacourse.service.to.AddressTo;

import java.util.List;

public interface AddressService {

    List<AddressTo> findAll();

    AddressTo findById(Long id);

    AddressTo save(AddressTo address);

    void delete(Long id);
}
