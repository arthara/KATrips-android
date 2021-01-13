package com.katripstask.katrips.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class UtilProvider {
    private static SharedPrefManager sharedPrefManager;

    public static void initialize(Context context){
        initSharedPreferences(context);
    }

    private static void initSharedPreferences(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("KATrips", Context.MODE_PRIVATE);
        sharedPrefManager = new SharedPrefManager(sharedPreferences);
    }

    public static SharedPrefManager getSharedPrefManager(){
        return sharedPrefManager;
    }
}
