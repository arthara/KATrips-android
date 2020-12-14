package com.katripstask.katrips.modul.login;

import android.util.Log;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.response.StasiunResponse;

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
            public StasiunResponse requestSuccess(LoginResponse data) {
                view.loginSuccess(data.access_token);
                interactor.saveToken(data.access_token);
                return null;
            }

            @Override
            public void requestFailed(String failedMsg) {
                view.loginFailed(failedMsg);
            }
        });
    }
}
