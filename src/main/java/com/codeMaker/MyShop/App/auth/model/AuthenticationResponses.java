package com.codeMaker.MyShop.App.auth.model;


import com.codeMaker.MyShop.App.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponses {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String password;
    private Set<Role> roles;
    private String token;
}
