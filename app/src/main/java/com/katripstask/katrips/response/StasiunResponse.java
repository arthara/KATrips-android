package com.katripstask.katrips.response;

import com.google.gson.annotations.SerializedName;
import com.katripstask.katrips.model.Stasiun;

import java.util.List;

public class StasiunResponse {
    public boolean success;
    public String message;
    @SerializedName("stasiun")
    public List<Stasiun> stasiuns;
}
