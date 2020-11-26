package com.katripstask.katrips.modul.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.response.LoginResponse;

public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View view;
    private final LoginContract.Interactor interactor;

    public LoginPresenter(LoginContract.View view, LoginContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {

    }

    @Override
    public void performLogin(String email, String password) {

        interactor.requestLogin(email, password, new RequestCallback<LoginResponse>() {
            @Override
            public void requestSuccess(LoginResponse data) {
                view.loginSuccess();
                interactor.saveToken(data.access_token);
            }

            @Override
            public void requestFailed(String failedMsg) {
                view.loginFailed(failedMsg);
            }
        });
    }
}
