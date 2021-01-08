package com.katripstask.katrips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class landing_page_new extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_new);

        ImageButton btn = (ImageButton) findViewById(R.id.imgShowMenu);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(landing_page_new.this, v);

                popup.setOnMenuItemClickListener(landing_page_new.this);
                popup.inflate(R.menu.menu_nav_bar);
                popup.show();
                Log.d("cek","cekbisa");
            }
        });
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.logout:
                // do your code
                return true;
            case R.id.history:
                // do your code
                return true;
            default:
                return false;
        }
    }

}