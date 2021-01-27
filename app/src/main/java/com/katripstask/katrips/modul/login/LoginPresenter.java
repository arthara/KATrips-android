package com.katripstask.katrips.modul.login;

import android.util.Log;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.User;
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
    public void performLogin(final String email, String password) {
        interactor.requestLogin(email, password, new RequestCallback<LoginResponse>() {
            @Override
            public void requestSuccess(LoginResponse data) {
                interactor.saveToken(data.access_token);
                String[] temp = email.split("@");
                User user = new User(1, temp[0], email, "Jl. Pens No. 12", "12 Januari 2020");
                interactor.saveUser(user);
                view.loginSuccess(data.access_token);
            }

            @Override
            public void requestFailed(String failedMsg) {
                view.loginFailed(failedMsg);
            }
        });
    }
}
