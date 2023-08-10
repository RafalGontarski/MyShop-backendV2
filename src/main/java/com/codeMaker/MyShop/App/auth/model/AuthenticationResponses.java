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
    private String email;
    private Set<Role> roles;
    private String token;
}
