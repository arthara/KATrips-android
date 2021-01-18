package com.katripstask.katrips.modul.caritiket;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.katripstask.katrips.R;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.modul.login.LoginActivity;
import com.katripstask.katrips.modul.pilihtiket.PilihTiketActivity;
import com.katripstask.katrips.request.PerjalananRequest;
import com.katripstask.katrips.utils.UtilProvider;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CariTiketFragment extends BaseFragment<CariTiketActivity, CariTiketContract.Presenter> implements CariTiketContract.View {
    Spinner spnrStasiunDari, spnrStasiunKe, spnrJmlhDws, spnrJmlhBy;
    FloatingActionButton btn_cariTiket;
    EditText etTglBerangkat;
    Calendar tglBerangkat;
    int idStasiunAwal, idStasiunTujuan, jmlhPenumpangDws, jmlhPenumpangBy;
    BottomAppBar bottomAppBar;
    DatePickerDialog.OnDateSetListener date;
    List<Stasiun> stasiuns = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_cari_tiket, container, false);
        mPresenter = new CariTiketPresenter(this, new CariTiketInteractor(UtilProvider.getSharedPrefManager()));
        mPresenter.requestListStasiun();
        initView();

        // Edit Text Date Picker Listener
        final Calendar mCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel(mCalendar);
                tglBerangkat = mCalendar;
            }
        };
        etTglBerangkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(activity, date,
                        mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH),
                        mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Button cari tiket listener
        btn_cariTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCariTiketAction();
            }
        });

        // Stasiun Awal Listener
        spnrStasiunDari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Stasiun awal = (Stasiun) adapterView.getSelectedItem();
                idStasiunAwal = awal.getStasiunId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("input", "Nothing Selected");
            }
        });

        // Spinner Tujuan Listener
        spnrStasiunKe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Stasiun tujuan = (Stasiun) adapterView.getSelectedItem();
                idStasiunTujuan = tujuan.getStasiunId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d("input", "Nothing Selected");
            }
        });

        // Spinner Penumpang Dewasa
        spnrJmlhDws.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                jmlhPenumpangDws = (int) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Spinner Penumpang Bayi
        spnrJmlhBy.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                jmlhPenumpangBy = (int) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.btmAppBarItem_logout:
                        Toast.makeText(activity, "LOGOUT", Toast.LENGTH_SHORT).show();
                        mPresenter.logout();
                        Intent intent = new Intent(activity, LoginActivity.class);
                        startActivity(intent);
                        activity.finish();
                        break;
                    default:
                        Log.d("cek", "Menu item not clicked");
                        break;
                }
                return false;
            }
        });

        return fragmentView;
    }

    private void btnCariTiketAction(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        PerjalananRequest perjalananRequest = new PerjalananRequest(dateFormat.format(tglBerangkat.getTime()), idStasiunAwal, idStasiunTujuan, jmlhPenumpangDws, jmlhPenumpangBy);
        mPresenter.requestListPerjalanan(perjalananRequest);
        //mPresenter.requestListPerjalanan(idStasiunAwal, idStasiunTujuan, dateFormat.format(tglBerangkat.getTime()));
    }

    private void initView(){
        spnrStasiunDari = fragmentView.findViewById(R.id.list_stasiun_dari);
        spnrStasiunKe = fragmentView.findViewById(R.id.list_stasiun_ke);
        spnrJmlhDws = fragmentView.findViewById(R.id.list_jmlh_dewasa);
        spnrJmlhBy = fragmentView.findViewById(R.id.list_jmlh_bayi);
        btn_cariTiket = fragmentView.findViewById(R.id.btn_cariTiket);
        etTglBerangkat = fragmentView.findViewById(R.id.et_tglBerangkat);
        tglBerangkat  = Calendar.getInstance();
        setSpinnerPenumpang();
        bottomAppBar = fragmentView.findViewById(R.id.bottomAppBar3);
        bottomAppBar.replaceMenu(R.menu.menu_nav_bar);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void updateLabel(Calendar mCalendar){
        String myFormat = "dd-M-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etTglBerangkat.setText(sdf.format(mCalendar.getTime()));
    }

    private void setSpinnerPenumpang(){
        Integer[] batasPenumpang = new Integer[]{1, 2, 3, 4, 5};
        Integer[] batasPenumpangBayi = new Integer[]{0, 1};
        ArrayAdapter<Integer> penumpangDwsAdapter = new ArrayAdapter<>(activity, R.layout.item_stasiun, batasPenumpang);
        ArrayAdapter<Integer> penumpangBayiAdapter = new ArrayAdapter<>(activity, R.layout.item_stasiun, batasPenumpangBayi);
        penumpangBayiAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        penumpangDwsAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnrJmlhBy.setAdapter(penumpangBayiAdapter);
        spnrJmlhDws.setAdapter(penumpangDwsAdapter);
    }

    @Override
    public void setSpinnerStasiun(List<Stasiun> stasiuns) {
        this.stasiuns = stasiuns;
        ArrayAdapter<Stasiun> stasiunAdapter = new ArrayAdapter<>(activity, R.layout.item_stasiun, stasiuns);
        stasiunAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnrStasiunKe.setAdapter(stasiunAdapter);
        spnrStasiunDari.setAdapter(stasiunAdapter);
    }

    @Override
    public void tiketDitemukan(List<Perjalanan> perjalanans) {
        for(int i=0;  i<perjalanans.size(); i++){
            Boolean setStasiunAsal = false;
            Boolean setStasiunTiba = false;
            for(int j=0; j<stasiuns.size(); j++){
                if(!(setStasiunAsal)){
                    if(perjalanans.get(i).getLokasiBerangkatId() == stasiuns.get(j).getStasiunId()){
                        perjalanans.get(i).setLokasiBerangkat(stasiuns.get(j));
                        setStasiunAsal = true;
                    }
                }
                if(!(setStasiunTiba)){
                    if(perjalanans.get(i).getLokasiTibaId() == stasiuns.get(j).getStasiunId()){
                        perjalanans.get(i).setLokasiTiba(stasiuns.get(j));
                        setStasiunTiba = true;
                    }
                }
                if(setStasiunAsal && setStasiunTiba) break;
            }
        }
        Intent intent = new Intent(activity, PilihTiketActivity.class);
        intent.putExtra("perjalanans", (Serializable) perjalanans);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void tiketTidakDitemukan(String failedMsg) {
        Toast.makeText(activity, failedMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(CariTiketContract.Presenter presenter) {
        mPresenter = presenter;
    }

}
