package com.katripstask.katrips.modul.register;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.User;
import com.katripstask.katrips.request.RegisterUserRequest;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.response.RegisterUserResponse;

public class RegisterPresenter implements RegisterContract.Presenter {
    private final RegisterContract.View view;
    private final RegisterContract.Interactor interactor;

    public RegisterPresenter(RegisterContract.View view, RegisterContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {

    }

    @Override
    public void performRegister(RegisterUserRequest registerUserRequest) {
        interactor.requestRegister(registerUserRequest, new RequestCallback<RegisterUserResponse>() {
            @Override
            public void requestSuccess(RegisterUserResponse data) {
                view.registerSuccess();
            }

            @Override
            public void requestFailed(String failedMsg) {
                view.registerFailed(failedMsg);
            }
        });
    }

    @Override
    public void redirectToLogin() {
        view.loginPage();
    }
}
