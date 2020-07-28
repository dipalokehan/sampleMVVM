package com.github.easymvvm.repository;


import com.github.easymvvm.repository.model.LoginRequest;
import com.github.easymvvm.repository.model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("goldenq/api/member/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);
}
