package com.katripstask.katrips.response;

import com.katripstask.katrips.model.User;

public class LoginResponse {
    public boolean isSuccess;
    public String access_token;
    public String token_type;
    public String message;
    public User user;
}
