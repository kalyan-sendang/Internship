package com.task.lms.service;

import com.task.lms.model.User;

public class TokenResponse {
    private  String token;

    public TokenResponse(String token ) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}