package com.katripstask.katrips.modul.register;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.constant.ApiConstant;
import com.katripstask.katrips.model.User;
import com.katripstask.katrips.request.RegisterUserRequest;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.response.RegisterUserResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

public class RegisterInteractor implements RegisterContract.Interactor {
    private SharedPrefManager sharedPrefManager;

    public RegisterInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }

    @Override
    public void requestRegister(RegisterUserRequest registerUserRequest, final RequestCallback<RegisterUserResponse> requestCallback) {
        AndroidNetworking.post(ApiConstant.BASE_URL + "register")
                .addBodyParameter(registerUserRequest)
                .build()
                .getAsObject(RegisterUserResponse.class, new ParsedRequestListener<RegisterUserResponse>() {
                    @Override
                    public void onResponse(RegisterUserResponse response) {
                        if(response == null){
                            requestCallback.requestFailed("Null Response");
                        }else if(response.message.equals("User successfully registered")){
                            requestCallback.requestSuccess(response);
                        }else{
                            requestCallback.requestFailed("Gagal Login");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        requestCallback.requestFailed(anError.getErrorBody());
                    }
                });
    }
}
