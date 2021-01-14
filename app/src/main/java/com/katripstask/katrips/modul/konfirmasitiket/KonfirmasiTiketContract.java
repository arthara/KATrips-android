package com.katripstask.katrips.modul.konfirmasitiket;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.Penumpang;
import com.katripstask.katrips.request.PesanTiketRequest;
import com.katripstask.katrips.response.KonfirmasiTiketResponse;
import com.katripstask.katrips.model.User;

import java.util.List;

public interface KonfirmasiTiketContract {
    interface View extends BaseView<Presenter> {
        void checkOut(int kodePembayaran);
        void backToInputPesanan(String failedMsg);
    }

    interface Presenter extends BasePresenter{
        void pesanTiket(PesanTiketRequest pesanTiketRequest); // Needed Parameter =data Penumpang (nama, no_ktp, bayi_id, id Perjalanan)
        int getKodePembayaran();
    }

    interface Interactor{
        void pesanTiket(PesanTiketRequest pesanTiketRequest, RequestCallback<KonfirmasiTiketResponse> requestCallback);
    }
}
