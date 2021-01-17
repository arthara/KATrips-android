package com.katripstask.katrips.modul.inputpesanan;

import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.User;

public class InputPesananPresenter implements InputPesananContract.Presenter {
    private final InputPesananContract.View view;
    private final InputPesananContract.Interactor interactor;

    public InputPesananPresenter(InputPesananContract.View view, InputPesananContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {

    }

    @Override
    public void backToPilihTiket() {
        view.redirectToPilihTiket();
    }

    @Override
    public void checkout(Perjalanan perjalanan) {
        view.redireckToCheckout(perjalanan);
    }

    @Override
    public User getUser() {
        return interactor.getUser();
    }

}
