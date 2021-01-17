package com.katripstask.katrips.modul.pilihtiket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.katripstask.katrips.MainActivity;
import com.katripstask.katrips.R;
import com.katripstask.katrips.adapter.PerjalananAdapter;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.modul.caritiket.CariTiketActivity;
import com.katripstask.katrips.modul.inputpesanan.InputPesananActivity;
import com.katripstask.katrips.utils.UtilProvider;

import java.io.Serializable;
import java.util.List;

public class PilihTiketFragment extends BaseFragment<PilihTiketActivity, PilihTiketContract.Presenter> implements PilihTiketContract.View {
    RecyclerView recyclerView;
    TextView tv_kodeStasiunAsal, tv_KodeStasiunTujuan, tv_stasiunAsal, tv_stasiunTujuan;
    List<Perjalanan> perjalanans;
    ImageView iv_backBtn;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_perjalanan, container, false);
        mPresenter = new PilihTiketPresenter(this, new PilihTiketInteractor(UtilProvider.getSharedPrefManager()));
        initView();
        setInitView();
        PerjalananAdapter perjalananAdapter = new PerjalananAdapter(activity, perjalanans);
        recyclerView.setAdapter(perjalananAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        perjalananAdapter.setOnItemClickListener(new PerjalananAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Perjalanan perjalanan = perjalanans.get(position);
                mPresenter.tiketDipilih(perjalanan);
            }
        });

        iv_backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CariTiketActivity.class);
                startActivity(intent);
                activity.finish();
            }
        });

        return fragmentView;
    }

    private void initView(){
        perjalanans = (List<Perjalanan>) getActivity().getIntent().getSerializableExtra("listPerjalanan");
        tv_kodeStasiunAsal = fragmentView.findViewById(R.id.tv_pilihTiket_kodeStasiunAwal);
        tv_KodeStasiunTujuan = fragmentView.findViewById(R.id.tv_pilihTiket_kodeStasiunTujuan);
        tv_stasiunAsal = fragmentView.findViewById(R.id.tv_pilihTiket_stasiunAsal);
        tv_stasiunTujuan = fragmentView.findViewById(R.id.tv_pilihTiket_stasiunTujuan);
        recyclerView = fragmentView.findViewById(R.id.rv_pilihTiket_listPerjalanan);
        iv_backBtn = fragmentView.findViewById(R.id.iv_pilihTiket_backBtn);
    }

    private void setInitView(){
        tv_kodeStasiunAsal.setText(perjalanans.get(0).getLokasiBerangkat().getKode());
        tv_KodeStasiunTujuan.setText(perjalanans.get(0).getLokasiTiba().getKode());
        tv_stasiunAsal.setText(perjalanans.get(0).getLokasiBerangkat().getNama());
        tv_stasiunTujuan.setText(perjalanans.get(0).getLokasiTiba().getNama());
    }



    @Override
    public void setPresenter(PilihTiketContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void pesanTiket(Perjalanan perjalanan) {
        Intent intent = new Intent(activity, InputPesananActivity.class); //Harusnya ke InputPesanan
        intent.putExtra("perjalanan", (Serializable) perjalanan);
        startActivity(intent);
    }

    @Override
    public void redirectToCariTiket() {
        Intent intent = new Intent(activity, CariTiketActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
