package com.katripstask.katrips.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.katripstask.katrips.request.TiketRequest;

import java.util.List;

public class FindedTiketResponse {
    public int jmlhTiket;
    @SerializedName("tiket")
    @Expose
    private List<TiketRequest> tiketRequests = null;

    public List<TiketRequest> getTiketRequests(){
        return tiketRequests;
    }

}
