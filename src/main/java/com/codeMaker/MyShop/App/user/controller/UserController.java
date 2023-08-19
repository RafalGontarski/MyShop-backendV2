package com.codeMaker.MyShop.App.user.controller;

import com.codeMaker.MyShop.App.auth.model.AuthUserResponse;
import com.codeMaker.MyShop.App.user.model.EmailUpdateRequest;
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
}
