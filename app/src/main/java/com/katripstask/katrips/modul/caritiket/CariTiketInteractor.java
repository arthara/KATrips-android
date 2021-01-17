package com.katripstask.katrips.modul.caritiket;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.constant.ApiConstant;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.response.FindedTiketResponse;
import com.katripstask.katrips.response.PerjalananResponse;
import com.katripstask.katrips.response.StasiunResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class CariTiketInteractor implements CariTiketContract.Interactor {
    private SharedPrefManager sharedPrefManager;
    private FindedTiketResponse findedTiketResponse;

    public CariTiketInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }

    @Override
    public void getAllStasiun(final RequestCallback<List<Stasiun>> requestCallback) {
        AndroidNetworking.get(ApiConstant.BASE_URL + "stasiun")
                .addHeaders("Authorization", "Bearer " + sharedPrefManager.getToken())
                .build()
                .getAsObject(StasiunResponse.class, new ParsedRequestListener<StasiunResponse>() {
                    @Override
                    public void onResponse(StasiunResponse response) {
                        if(response.success == false){
                            requestCallback.requestFailed("Failed Get Stasiuns");
                        }else{
                            requestCallback.requestSuccess(response.stasiuns);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("StasiunInteractor", anError.getMessage() );
                        requestCallback.requestFailed(anError.getMessage());
                    }
                });
    }

    @Override
    public void requestPerjalanan(PerjalananRequest perjalananRequest, final RequestCallback<PerjalananResponse> requestCallback) {
        AndroidNetworking.post(ApiConstant.BASE_URL + "cari-perjalanan")
                .addHeaders("Authorization", "Bearer " + sharedPrefManager.getToken())
                .addBodyParameter(perjalananRequest)
                .build()
                .getAsObject(PerjalananResponse.class, new ParsedRequestListener<PerjalananResponse>() {
                    @Override
                    public void onResponse(PerjalananResponse response) {
                        if(response.success == true){
                            requestCallback.requestSuccess(response);
                        }else if(response.success == false){
                            Log.d("cek", "Fail 1 ");
                            requestCallback.requestFailed("Failed Get Trip");
                        }else{
                            Log.d("cek", "Fail 2 ");
                            requestCallback.requestFailed("Null Response");
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("cek", "onError errorCode : " + anError.getErrorCode());
                        Log.d("cek", "onError errorBody : " + anError.getErrorBody());
                        Log.d("cek", "onError errorDetail : " + anError.getErrorDetail());
                        requestCallback.requestFailed(anError.getErrorBody());
                    }
                });
    }
}
