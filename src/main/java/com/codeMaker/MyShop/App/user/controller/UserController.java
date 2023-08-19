package com.codeMaker.MyShop.App.user.controller;

import com.codeMaker.MyShop.App.auth.model.AuthUserResponse;
import com.codeMaker.MyShop.App.user.model.AddressUpdateRequest;
import com.codeMaker.MyShop.App.user.model.EmailUpdateRequest;
import com.codeMaker.MyShop.App.user.model.FirstNameUpdateRequest;
import com.codeMaker.MyShop.App.user.model.User;
import com.codeMaker.MyShop.App.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public ResponseEntity<AuthUserResponse> getCurrentUser(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(new AuthUserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getRoles()));
    }

    @PatchMapping("/{userId}/email")
    public ResponseEntity<?> updateEmail(@PathVariable Long userId, @RequestBody EmailUpdateRequest emailRequest) {
        userService.updateEmail(userId, emailRequest.getEmail());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}/address")
    public ResponseEntity<?> updateAddress(@PathVariable Long userId, @RequestBody AddressUpdateRequest addressRequest) {
        userService.updateAddress(userId, addressRequest);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{userId}/firstName")
    public ResponseEntity<?> updateFirstName(@PathVariable Long userId, @RequestBody FirstNameUpdateRequest firstNameRequest) {
        userService.updateFirstName(userId, firstNameRequest.getFirstName());
        return ResponseEntity.ok().build();
    }

}
