package com.hellofan.backend.dto;

import com.hellofan.backend.model.generator.User;

public class UserDto {

    private User user;

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
