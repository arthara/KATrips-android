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
    public void checkOut(Perjalanan perjalanan) {
        view.redirectToCheckOut(perjalanan);
    }

    @Override
    public void backToCariTiket() {
        view.redirectToCariTiket();
    }

    @Override
    public User getUser() {
        return interactor.getUser();
    }

}
