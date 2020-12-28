package com.katripstask.katrips.modul.pilihtiket;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.response.PerjalananResponse;

import java.util.List;

public interface PilihTiketContract {
    interface View extends BaseView<Presenter> {
        void pesanTiket(Perjalanan perjalanan);
        void redirectToCariTiket();
    }

    interface Presenter extends BasePresenter{
        void tiketDipilih(Perjalanan perjalanan);
        void kembaliKeCariTiket();
    }

    interface Interactor{
     }
}
