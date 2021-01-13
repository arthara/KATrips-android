package com.katripstask.katrips.modul.login;

import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.constant.ApiConstant;
import com.katripstask.katrips.model.User;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

public class LoginInteractor implements LoginContract.Interactor {
    private SharedPrefManager sharedPrefManager;

    public LoginInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }

    @Override
    public void requestLogin(String email, String password, final RequestCallback<LoginResponse> requestCallback) {
        AndroidNetworking.post(ApiConstant.BASE_URL + "login")
                .addBodyParameter("email", email)
                .addBodyParameter("password", password)
                .build()
                .getAsObject(LoginResponse.class, new ParsedRequestListener<LoginResponse>() {
                    @Override
                    public void onResponse(LoginResponse response) {
                        if(response == null){
                            requestCallback.requestFailed("Null Response");
                        }else if(response.isSuccess){
                            requestCallback.requestSuccess(response);
                        }else{
                            requestCallback.requestFailed("Failed 1");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        requestCallback.requestFailed(anError.getMessage().toString());
                    }
                });
    }

    @Override
    public void saveToken(String token) {
        sharedPrefManager.setToken(token);
    }

    @Override
    public void saveUser(User user) {
        sharedPrefManager.setUser(user);
    }
}
