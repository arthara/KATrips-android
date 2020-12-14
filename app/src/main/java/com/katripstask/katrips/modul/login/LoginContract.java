package com.katripstask.katrips.modul.login;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.response.LoginResponse;

public interface LoginContract {
    interface View extends BaseView<Presenter> {
        void loginSuccess(String token);
        void loginFailed(String failedMsg);
    }

    interface Presenter extends BasePresenter{
        void performLogin(String email, String password);
    }

    interface Interactor{
        void requestLogin(String email, String password, RequestCallback<LoginResponse> requestCallback);
        void saveToken(String token);
    }
}
