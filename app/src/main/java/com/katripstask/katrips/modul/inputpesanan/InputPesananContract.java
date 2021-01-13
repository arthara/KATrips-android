package com.katripstask.katrips.modul.inputpesanan;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.User;

public interface InputPesananContract {
    interface View extends BaseView<Presenter> {
        void redirectToPilihTiket();
        void recireckToCheckout(Perjalanan perjalanan);
    }

    interface Presenter extends BasePresenter{
        void backToPilihTiket();
        void checkout(Perjalanan perjalanan);
        User getUser();
    }

    interface Interactor{
        User getUser();
     }
}
