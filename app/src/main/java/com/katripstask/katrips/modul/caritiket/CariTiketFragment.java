package com.katripstask.katrips.modul.caritiket;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.katripstask.katrips.MainActivity;
import com.katripstask.katrips.R;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Stasiun;
import com.katripstask.katrips.modul.login.LoginActivity;
import com.katripstask.katrips.modul.login.LoginContract;
import com.katripstask.katrips.modul.login.LoginInteractor;
import com.katripstask.katrips.modul.login.LoginPresenter;
import com.katripstask.katrips.response.FindedTiketResponse;
import com.katripstask.katrips.utils.UtilProvider;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class CariTiketFragment extends BaseFragment<CariTiketActivity, CariTiketContract.Presenter> implements CariTiketContract.View {
    Spinner spnrStasiunDari, spnrStasiunKe, spnrJmlhDws, spnrJmlhBy;
    FloatingActionButton btn_cariTiket;
    EditText etTglBerangkat;
    Calendar tglBerangkat;
    DatePickerDialog.OnDateSetListener date;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_cari_tiket, container, false);
        mPresenter = new CariTiketPresenter(this, new CariTiketInteractor(UtilProvider.getSharedPrefManager()));
        mPresenter.requestListStasiun();
        initView();
        setTglDefault();

        btn_cariTiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCariTiketAction();
            }
        });

        return fragmentView;
    }

    private void btnCariTiketAction(){
        final int[] stasiunAwalId = new int[1];
        final int[] stasiunTujuanId = new int[1];

        spnrStasiunDari.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Stasiun stasiunDari = (Stasiun) adapterView.getSelectedItem();
                stasiunAwalId[0] = stasiunDari.getStasiunId();
            }
        });

        spnrStasiunKe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Stasiun stasiunTujuan = (Stasiun) adapterView.getSelectedItem();
                stasiunTujuanId[0] = stasiunTujuan.getStasiunId();
            }
        });

        etTglBerangkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(activity, date,
                        tglBerangkat.get(Calendar.YEAR),
                        tglBerangkat.get(Calendar.MONTH),
                        tglBerangkat.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        mPresenter.requestListPerjalanan(stasiunAwalId[0], stasiunTujuanId[0], dateFormat.format(tglBerangkat.getTime()));
    }

    private void initView(){
        spnrStasiunDari = fragmentView.findViewById(R.id.list_stasiun_dari);
        spnrStasiunKe = fragmentView.findViewById(R.id.list_stasiun_ke);
        spnrJmlhDws = fragmentView.findViewById(R.id.list_jmlh_dewasa);
        spnrJmlhBy = fragmentView.findViewById(R.id.list_jmlh_bayi);
        btn_cariTiket = fragmentView.findViewById(R.id.btn_cariTiket);
        etTglBerangkat = (EditText) fragmentView.findViewById(R.id.et_tglBerangkat);
        tglBerangkat  = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                tglBerangkat.set(Calendar.YEAR, year);
                tglBerangkat.set(Calendar.MONTH, month);
                tglBerangkat.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
    }

    private void updateLabel(){
        String myFormat = "yyyy/mm/dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etTglBerangkat.setText("IKI TANGGAL COK");
    }

    private void setTglDefault(){
        date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int tahun, int bulan, int tanggal) {
                tglBerangkat.set(Calendar.YEAR, tahun);
                tglBerangkat.set(Calendar.MONTH, bulan);
                tglBerangkat.set(Calendar.DAY_OF_MONTH, tanggal);

                String format = "dd/MM/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.ENGLISH);
                TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
                sdf.setTimeZone(tz);
                etTglBerangkat.setText(sdf.format(tglBerangkat.getTime()));
            }
        };
    }

    @Override
    public void setSpinnerStasiun(List<Stasiun> stasiuns) {
        ArrayAdapter<Stasiun> stasiunAdapter = new ArrayAdapter<Stasiun>(activity, android.R.layout.simple_spinner_item, stasiuns);
        stasiunAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spnrStasiunKe.setAdapter(stasiunAdapter);
        spnrStasiunDari.setAdapter(stasiunAdapter);
    }

    @Override
    public void tiketDitemukan() {
        Intent intent = new Intent(activity, MainActivity.class);
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
