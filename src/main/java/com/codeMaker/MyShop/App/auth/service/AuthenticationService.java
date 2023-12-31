package com.codeMaker.MyShop.App.auth.service;

import com.codeMaker.MyShop.App.auth.model.AuthenticationRequest;
import com.codeMaker.MyShop.App.auth.model.AuthenticationResponses;
import com.codeMaker.MyShop.App.auth.model.RegisterRequest;
import com.codeMaker.MyShop.App.config.jwt.JwtService;
import com.codeMaker.MyShop.App.user.model.Role;
import com.codeMaker.MyShop.App.user.model.User;
import com.codeMaker.MyShop.App.user.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponses register(RegisterRequest request) {
        var user = User.builder()
                .company(request.getCompany())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .address(request.getAddress())
                .postalCode(request.getPostalCode())
                .city(request.getCity())
                .country(request.getCountry())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton(Role.USER))
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponses.builder()
                .token(jwtToken)
                .email(request.getEmail())
                .roles(user.getRoles())
                .build();
    }

//    public void registerOwner(RegisterRequest request){
//        var user = User.builder()
//                .firstName(request.getFirstName())
//                .lastName(request.getLastName())
//                .email(request.getEmail())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .roles(Set.of(Role.OWNER, Role.USER))
//                .build();
//        repository.save(user);
//    }

    public AuthenticationResponses authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponses.builder()
                .token(jwtToken)
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .postalCode(user.getPostalCode())
                .city(user.getCity())
                .country(user.getCountry())
                .email(request.getEmail())
                .password(request.getPassword())
                .roles(user.getRoles())
                .build();
    }
    private static LocalDate convertStringtoData(String visitDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(visitDate, dateFormatter);
    }
}
