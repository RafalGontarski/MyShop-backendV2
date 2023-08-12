package com.codeMaker.MyShop.App.auth.controller;

import com.codeMaker.MyShop.App.auth.model.AuthenticationRequest;
import com.codeMaker.MyShop.App.auth.model.AuthenticationResponses;
import com.codeMaker.MyShop.App.auth.model.RegisterRequest;
import com.codeMaker.MyShop.App.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponses> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponses> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

}
