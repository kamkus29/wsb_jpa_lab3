package com.jpacourse.mapper;

import com.jpacourse.persistence.entity.AddressEntity;
import com.jpacourse.service.to.AddressTo;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressTo mapToTo(AddressEntity entity) {
        if (entity == null) return null;
        return AddressTo.builder()
                .id(entity.getId())
                .addressLine1(entity.getAddressLine1())
                .addressLine2(entity.getAddressLine2())
                .city(entity.getCity())
                .postalCode(entity.getPostalCode())
                .build();
    }

    public AddressEntity mapToEntity(AddressTo to) {
        if (to == null) return null;
        return AddressEntity.builder()
                .id(to.getId())
                .addressLine1(to.getAddressLine1())
                .addressLine2(to.getAddressLine2())
                .city(to.getCity())
                .postalCode(to.getPostalCode())
                .build();
    }
}
