package com.katripstask.katrips.modul.caritiket;

import android.util.Log;
import android.widget.Toast;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.request.TiketRequest;
import com.katripstask.katrips.response.FindedTiketResponse;
import com.katripstask.katrips.response.PerjalananResponse;
import com.katripstask.katrips.response.StasiunResponse;

import java.util.Date;
import java.util.List;

public class CariTiketPresenter implements CariTiketContract.Presenter {
    private final CariTiketContract.View view;
    private final CariTiketContract.Interactor interactor;

    public CariTiketPresenter(CariTiketContract.View view, CariTiketContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void requestListStasiun() {
        interactor.getAllStasiun(new RequestCallback<List<Stasiun>>() {
            @Override
            public void requestSuccess(List<Stasiun> data) {
                view.setSpinnerStasiun(data);
            }

            @Override
            public void requestFailed(String failedMsg) {

            }
        });
    }

    @Override
    public void requestListPerjalanan(PerjalananRequest perjalananRequest) {
        interactor.requestPerjalanan(perjalananRequest, new RequestCallback<PerjalananResponse>() {
            @Override
            public void requestSuccess(PerjalananResponse data) {
                view.tiketDitemukan(data.getPerjalanans());
            }

            @Override
            public void requestFailed(String failedMsg) {
                view.tiketTidakDitemukan(failedMsg);
            }
        });
    }

    @Override
    public void start() {

    }

    public void logout() {
        interactor.logout();
    }
}
