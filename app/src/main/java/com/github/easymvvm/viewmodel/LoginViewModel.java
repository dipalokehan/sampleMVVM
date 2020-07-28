package com.github.easymvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.github.easymvvm.repository.LoginRepository;
import com.github.easymvvm.repository.model.LoginResponse;

import java.util.List;

public class LoginViewModel extends ViewModel {

    private LoginRepository loginRepository;
    private MutableLiveData<LoginResponse> mutableLiveData;

    public LoginViewModel(){
        loginRepository = new LoginRepository();
    }

    public LiveData<LoginResponse> getLoginResponse(String username,String password) {
        if(mutableLiveData==null){
            mutableLiveData = loginRepository.requestLogin(username, password);
        }
        return mutableLiveData;
    }

}
