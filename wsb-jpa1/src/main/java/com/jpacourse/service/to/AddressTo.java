package com.jpacourse.service.to;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressTo {
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;
}
