package com.codeMaker.MyShop.App.auth.model;


import com.codeMaker.MyShop.App.user.model.User;

public class PasswordResetToken {
    private String token;
    private User user;

    public PasswordResetToken(User user, String token ) {
        this.user = user;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }



}
