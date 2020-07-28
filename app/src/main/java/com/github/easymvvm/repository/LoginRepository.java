package com.github.easymvvm.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.github.easymvvm.commons.MyApplication;
import com.github.easymvvm.repository.model.LoginRequest;
import com.github.easymvvm.repository.model.LoginResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<LoginResponse> requestLogin(String username,String password) {
        final MutableLiveData<LoginResponse> responseData = new MutableLiveData<>();

        ApiInterface apiService =
                MyApplication.getRetrofitClient().create(ApiInterface.class);

        apiService.login(new LoginRequest(username,password)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if (response.isSuccessful() && response.body()!=null ) {
                    responseData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e(TAG, "onFailure" + t.getLocalizedMessage());
            }
        });

        return responseData;
    }
}
