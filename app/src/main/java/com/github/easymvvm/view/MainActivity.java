package com.github.easymvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.github.easymvvm.R;
import com.github.easymvvm.commons.MyApplication;
import com.github.easymvvm.databinding.ActivityMainBinding;
import com.github.easymvvm.repository.model.LoginResponse;
import com.github.easymvvm.viewmodel.LoginViewModel;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MyApplication.getInstance().isNetworkAvailable()) {
                    binding.progressBar.setVisibility(View.VISIBLE);

                    LoginViewModel loginViewModel = new LoginViewModel();
                    loginViewModel.getLoginResponse(binding.editTextTextEmailAddress.getText().toString(),
                            binding.editTextTextPassword.getText().toString()).observe(MainActivity.this, new Observer<LoginResponse>() {
                        @Override
                        public void onChanged(LoginResponse loginResponse) {
                            binding.progressBar.setVisibility(View.GONE);
                            if(loginResponse.getSuccess())
                                Toast.makeText(MainActivity.this, loginResponse.getResult().getFirstName() +"Logged in successfully", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                        }
                    });

                }else{
                    Toast.makeText(MainActivity.this, "No Network Available", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
