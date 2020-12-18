package com.katripstask.katrips.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPrefManager {
    //private String spToken;

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPrefManager(SharedPreferences sp){
        this.sp = sp;
        this.spEditor = sp.edit();
    }

    public void setToken(String token){
        spEditor.putString("token", token).commit();
    }

    public String getToken(){
        return sp.getString("token", null);
    }

    public void clear(){
        spEditor.clear().commit();
    }
}
