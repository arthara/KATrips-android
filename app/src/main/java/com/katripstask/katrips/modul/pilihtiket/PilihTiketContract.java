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
        void pesanTiket(int idPerjalanan);
        void redirectToCariTiket();
    }

    interface Presenter extends BasePresenter{
        void tiketDipilih(int idPerjalanan);
        void kembaliKeCariTiket();
    }

    interface Interactor{
     }
}
