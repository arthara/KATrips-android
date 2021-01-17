package com.katripstask.katrips.modul.checkout;

import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.constant.ApiConstant;
import com.katripstask.katrips.request.TiketRequest;
import com.katripstask.katrips.response.KonfirmasiTiketResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

public class CheckoutInteractor implements CheckoutContract.Interactor {
    private SharedPrefManager sharedPrefManager;

    public CheckoutInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }

}
