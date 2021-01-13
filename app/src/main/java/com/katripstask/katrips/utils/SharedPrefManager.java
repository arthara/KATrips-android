package com.katripstask.katrips.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.katripstask.katrips.model.User;

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

    public void setUser(User user){
        Gson gson = new Gson();
        String json = gson.toJson(user);
        spEditor.putString("user", json).commit();
    }

    public User getUser(){
        Gson gson = new Gson();
        String json = sp.getString("user", "");
        User user = gson.fromJson(json, User.class);
        return user;
    }

    public void clear(){
        spEditor.clear().commit();
    }
}
