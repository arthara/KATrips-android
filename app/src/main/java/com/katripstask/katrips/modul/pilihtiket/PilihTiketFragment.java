package com.katripstask.katrips.modul.pilihtiket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.katripstask.katrips.MainActivity;
import com.katripstask.katrips.R;
import com.katripstask.katrips.adapter.PerjalananAdapter;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.modul.caritiket.CariTiketActivity;
import com.katripstask.katrips.utils.UtilProvider;

import java.util.List;

public class PilihTiketFragment extends BaseFragment<PilihTiketActivity, PilihTiketContract.Presenter> implements PilihTiketContract.View {
    RecyclerView recyclerView;
    TextView tv_kodeStasiunAsal, tv_KodeStasiunTujuan, tv_stasiunAsal, tv_stasiunTujuan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_perjalanan, container, false);
        mPresenter = new PilihTiketPresenter(this, new PilihTiketInteractor(UtilProvider.getSharedPrefManager()));
        initView();

        final List<Perjalanan> perjalanans = (List<Perjalanan>) getActivity().getIntent().getSerializableExtra("listPerjalanan");
        PerjalananAdapter perjalananAdapter = new PerjalananAdapter(activity, perjalanans);
        recyclerView.setAdapter(perjalananAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        perjalananAdapter.setOnItemClickListener(new PerjalananAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                int harga = perjalanans.get(position).getHarga();
                Toast.makeText(activity, "Harga terpilih : " + harga, Toast.LENGTH_SHORT).show();
            }
        });

        return fragmentView;
    }

    private void initView(){
        tv_kodeStasiunAsal = fragmentView.findViewById(R.id.tv_kodeStasiunAwal);
        tv_KodeStasiunTujuan = fragmentView.findViewById(R.id.tv_kodeStasiunTujuan);
        tv_stasiunAsal = fragmentView.findViewById(R.id.tv_stasiun_asal);
        tv_stasiunTujuan = fragmentView.findViewById(R.id.tv_stasiun_tujuan);
        recyclerView = fragmentView.findViewById(R.id.rv_listPerjalanan);
    }



    @Override
    public void setPresenter(PilihTiketContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void pesanTiket(int idPerjalanan) {
        Intent intent = new Intent(activity, MainActivity.class); //Harusnya ke InputPesanan
        Log.d("cek", "Halo");
        intent.putExtra("idPerjalanan", idPerjalanan);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void redirectToCariTiket() {
        Intent intent = new Intent(activity, CariTiketActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
