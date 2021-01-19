package com.katripstask.katrips.modul.konfirmasitiket;

import android.util.Log;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.request.PesanTiketRequest;
import com.katripstask.katrips.response.KonfirmasiTiketResponse;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.response.StasiunResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class KonfirmasiTiketPresenter implements KonfirmasiTiketContract.Presenter {
    private final KonfirmasiTiketContract.View view;
    private final KonfirmasiTiketContract.Interactor interactor;

    public KonfirmasiTiketPresenter(KonfirmasiTiketContract.View view, KonfirmasiTiketContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {

    }

    @Override
    public void pesanTiket(PesanTiketRequest pesanTiketRequest) {
        interactor.pesanTiket(pesanTiketRequest, new RequestCallback<JSONObject>() {
            @Override
            public void requestSuccess(JSONObject data) {
                view.checkOut(data.toString());
            }

            @Override
            public void requestFailed(String failedMsg) {
                view.backToInputPesanan(failedMsg);
            }
        });
    }

    @Override
    public int getKodePembayaran() {
        return 0;
    }
}
