package com.katripstask.katrips.modul.checkout;

import android.util.Log;

import com.katripstask.katrips.callback.RequestCallback;

public class CheckoutPresenter implements CheckoutContract.Presenter {
    private final CheckoutContract.View view;
    private final CheckoutContract.Interactor interactor;

    public CheckoutPresenter(CheckoutContract.View view, CheckoutContract.Interactor interactor){
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void start() {
    }

    @Override
    public void redirectToCariTiket(){
        view.backToCariTiket();
    }
}
