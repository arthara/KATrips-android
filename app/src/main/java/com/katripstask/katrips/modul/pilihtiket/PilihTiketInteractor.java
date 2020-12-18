package com.katripstask.katrips.modul.pilihtiket;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.constant.ApiConstant;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.modul.caritiket.CariTiketContract;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.response.FindedTiketResponse;
import com.katripstask.katrips.response.PerjalananResponse;
import com.katripstask.katrips.response.StasiunResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

import java.util.List;

public class PilihTiketInteractor implements PilihTiketContract.Interactor {
    private SharedPrefManager sharedPrefManager;
    private FindedTiketResponse findedTiketResponse;

    public PilihTiketInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }
}
