package com.codeMaker.MyShop.App.auth.model;


import com.codeMaker.MyShop.App.user.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthUserResponse {
    private String email;
    private Set<Role> roles;
}
