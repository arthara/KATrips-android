package com.katripstask.katrips.modul.caritiket;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.request.TiketRequest;
import com.katripstask.katrips.response.FindedTiketResponse;
import com.katripstask.katrips.response.LoginResponse;
import com.katripstask.katrips.response.PerjalananResponse;
import com.katripstask.katrips.response.StasiunResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface CariTiketContract {
    interface View extends BaseView<Presenter> {
        void setSpinnerStasiun(List<Stasiun> stasiuns);
        void tiketDitemukan();
        void tiketTidakDitemukan(String failedMsg);
    }

    interface Presenter extends BasePresenter{
        void requestListStasiun();
        void requestListPerjalanan(int lokasiBrngktId, int lokasiTbId, String tglBerangkat);
    }

    interface Interactor{
        void getAllStasiun(RequestCallback<List<Stasiun>> requestCallback);
        void requestPerjalanan(PerjalananRequest perjalananRequest, RequestCallback<PerjalananResponse> requestCallback);
    }
}