package com.github.easymvvm.repository.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("username")
    @Expose
    public String username;
    @SerializedName("user_password")
    @Expose
    public String userPassword;

    /**
     * No args constructor for use in serialization
     *
     */
    public LoginRequest() {
    }

    /**
     *
     * @param userPassword
     * @param username
     */
    public LoginRequest(String username, String userPassword) {
        super();
        this.username = username;
        this.userPassword = userPassword;
    }
}
