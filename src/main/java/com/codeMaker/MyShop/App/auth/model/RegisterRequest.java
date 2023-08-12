package com.codeMaker.MyShop.App.auth.model;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @Column(nullable = true)
    private String company;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String city;
    private String country;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String repeatPassword;

}
