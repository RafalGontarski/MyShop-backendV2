package com.codeMaker.MyShop.App.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressUpdateRequest {
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String country;
}
