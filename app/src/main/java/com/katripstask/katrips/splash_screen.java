package com.katripstask.katrips;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

import com.katripstask.katrips.modul.login.LoginActivity;

public class splash_screen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {

            /*

             * menampilkan splash screen dengan timer

             * untuk kasus ini saya menampilkan text saja. Anda bisa menambahkan sesuai dengan keinginan anda

             */

            @Override

            public void run() {

                // method ini akan di eksekusi setelah timer selesai

                // start Main activity

                Intent i = new Intent(splash_screen.this, LoginActivity.class);

                startActivity(i);

                // tutup activity ini

                finish();

            }

        }, SPLASH_TIME_OUT);
    }
}