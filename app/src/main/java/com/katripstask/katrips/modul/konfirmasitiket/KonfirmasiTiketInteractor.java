package com.katripstask.katrips.modul.konfirmasitiket;

import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.gson.Gson;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.constant.ApiConstant;
import com.katripstask.katrips.request.PesanTiketRequest;
import com.katripstask.katrips.request.TiketRequest;
import com.katripstask.katrips.response.KonfirmasiTiketResponse;
import com.katripstask.katrips.utils.SharedPrefManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KonfirmasiTiketInteractor implements KonfirmasiTiketContract.Interactor {
    private SharedPrefManager sharedPrefManager;

    public KonfirmasiTiketInteractor(SharedPrefManager sharedPrefManager){
        this.sharedPrefManager = sharedPrefManager;
    }

    @Override
    public void pesanTiket(PesanTiketRequest pesanTiketRequest, final RequestCallback<JSONObject> requestCallback){
        JSONArray penumpangs = new JSONArray();
        JSONObject tiketRequest = new JSONObject();
        for(int i=0; i<pesanTiketRequest.getPenumpangs().size(); i++){
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("nama_ktp", pesanTiketRequest.getPenumpangs().get(i).getNama());
                jsonObject.put("no_ktp", pesanTiketRequest.getPenumpangs().get(i).getNoKtp());
                jsonObject.put("is_dewasa", pesanTiketRequest.getPenumpangs().get(0).getIsDewasa());
                penumpangs.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            tiketRequest.put("id_perjalanan", pesanTiketRequest.getIdPerjalanan());
            tiketRequest.put("penumpangs", penumpangs);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AndroidNetworking.post(ApiConstant.BASE_URL + "tiket/pesan")
                .addHeaders("Authorization", "Bearer " + sharedPrefManager.getToken())
                .addHeaders("content-type", "application/json")
                .addHeaders("Accept", "application/json")
                .addJSONObjectBody(tiketRequest)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("cek", response.toString());
                        requestCallback.requestSuccess(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("cek", anError.getResponse().toString());
                        Log.d("cek", anError.getErrorBody());
                        Log.d("cek", anError.getErrorDetail());
                        requestCallback.requestFailed(anError.getErrorBody());
                    }
                });
    }
}
