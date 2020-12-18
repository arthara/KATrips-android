package com.katripstask.katrips.modul.pilihtiket;

import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.modul.caritiket.CariTiketContract;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.response.PerjalananResponse;

import java.util.List;

public class PilihTiketPresenter implements PilihTiketContract.Presenter {
    private final PilihTiketContract.View view;
    private final PilihTiketContract.Interactor interactor;

    public PilihTiketPresenter(PilihTiketContract.View view, PilihTiketContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {

    }

    @Override
    public void tiketDipilih(int idPerjalanan) {
        view.pesanTiket(idPerjalanan);
    }

    @Override
    public void kembaliKeCariTiket() {
        view.redirectToCariTiket();
    }
}
