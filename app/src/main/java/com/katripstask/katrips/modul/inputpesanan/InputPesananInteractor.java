package com.katripstask.katrips.modul.inputpesanan;

import com.katripstask.katrips.model.User;
import com.katripstask.katrips.response.FindedTiketResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

public class InputPesananInteractor implements InputPesananContract.Interactor {
    private SharedPrefManager sharedPrefManager;
    private FindedTiketResponse findedTiketResponse;

    public InputPesananInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }

    @Override
    public User getUser() {
        return sharedPrefManager.getUser();
    }
}
