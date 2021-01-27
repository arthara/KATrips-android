package com.katripstask.katrips.modul.register;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.User;
import com.katripstask.katrips.request.RegisterUserRequest;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.response.RegisterUserResponse;

public interface RegisterContract {
    interface View extends BaseView<Presenter> {
        void registerSuccess();
        void registerFailed(String failedMsg);
        void loginPage();
    }

    interface Presenter extends BasePresenter{
        void performRegister(RegisterUserRequest registerUserRequest);
        void redirectToLogin();
    }

    interface Interactor{
        void requestRegister(RegisterUserRequest registerUserRequest, RequestCallback<RegisterUserResponse> requestCallback);
    }
}
