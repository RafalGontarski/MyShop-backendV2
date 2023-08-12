package com.codeMaker.MyShop.App.user.controller;

import com.codeMaker.MyShop.App.user.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public void getCurrentUser(String email) {
        return userService.getUser(email);
    }
}
