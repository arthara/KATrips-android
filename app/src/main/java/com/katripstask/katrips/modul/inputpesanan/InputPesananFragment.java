package com.katripstask.katrips.modul.inputpesanan;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.katripstask.katrips.MainActivity;
import com.katripstask.katrips.R;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.utils.UtilProvider;

import java.io.Serializable;


public class InputPesananFragment extends BaseFragment<InputPesananActivity, InputPesananContract.Presenter> implements InputPesananContract.View {
    TextView tv_stasiunAsal, tv_stasiunTujuan, tv_jamKeberangkatan;
    TextView tv_jamTiba, tv_kelas, tv_kereta, tv_durasi, tv_harga;

    TextView  tv_namaUser, tv_emailUser;
    EditText et_noKtp, et_namaPenumpang;
    TextView tv_totalHarga, tv_detailHarga, tv_kategori;

    FloatingActionButton btn_checkOut;
    Perjalanan perjalananDipesan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.input_pesan, container, false);
        mPresenter = new InputPesananPresenter(this, new InputPesananInteractor(UtilProvider.getSharedPrefManager()));
        initView();
        setInitView();

        btn_checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCheckoutAction();
            }
        });

        return fragmentView;
    }

    private void initView(){
        tv_stasiunAsal = fragmentView.findViewById(R.id.tv_stasiunAwal_inptPesan);
        tv_stasiunTujuan = fragmentView.findViewById(R.id.tv_stasiunTujuan_inptPesan);
        tv_jamKeberangkatan = fragmentView.findViewById(R.id.tv_waktuBerangkat_inptPesan);
        tv_jamTiba = fragmentView.findViewById(R.id.tv_waktuTiba_inptPesan);
        tv_kelas = fragmentView.findViewById(R.id.tv_kelas_inptPesan);
        tv_kereta = fragmentView.findViewById(R.id.tv_kelas_inptPesan);
        tv_durasi = fragmentView.findViewById(R.id.tv_durasiPerjalanan_inptPesan);
        tv_harga = fragmentView.findViewById(R.id.tv_harga_inptPesan);

        tv_namaUser = fragmentView.findViewById(R.id.tv_namaUser_inptPesan);
        tv_emailUser = fragmentView.findViewById(R.id.tv_emailUser_inptPesan);

        tv_kategori = fragmentView.findViewById(R.id.tv_kategoriPnmpng_inptPesan);
        et_namaPenumpang = fragmentView.findViewById(R.id.et_namaPenumpang_inptPesan);
        et_noKtp = fragmentView.findViewById(R.id.et_noKtpPnmpng_inptPesan);

        tv_totalHarga = fragmentView.findViewById(R.id.tv_totalHarga_inptPesan);
        tv_detailHarga = fragmentView.findViewById(R.id.tv_jmlhPenumpang_inptPesan);

        btn_checkOut = fragmentView.findViewById(R.id.btn_checkOut_inptPesanan);
    }

    private void setInitView(){
        perjalananDipesan = (Perjalanan) getActivity().getIntent().getSerializableExtra("perjalanan");
        tv_stasiunAsal.setText(perjalananDipesan.getLokasiBerangkat());
        tv_stasiunTujuan.setText(perjalananDipesan.getLokasiTiba());
        tv_jamKeberangkatan.setText(perjalananDipesan.getWaktuBerangkat(false));
        tv_jamTiba.setText(perjalananDipesan.getWaktuTiba(false));
        tv_kelas.setText(perjalananDipesan.getKelas());
        tv_kereta.setText(perjalananDipesan.getKereta());
        tv_durasi.setText("2 Jam 3 Menit");
        tv_harga.setText("Rp. " + perjalananDipesan.getHarga());

        tv_namaUser.setText(mPresenter.getUser().getNama());
        tv_emailUser.setText(mPresenter.getUser().getEmail());
        tv_totalHarga.setText("Rp. " + perjalananDipesan.getHarga()); // Static Value
        tv_kategori.setText("Kategori : Dewasa"); // Static Value
    }

    private void btnCheckoutAction(){
        mPresenter.checkout(perjalananDipesan);
    }

    @Override
    public void redirectToPilihTiket() {

    }

    @Override
    public void recireckToCheckout(Perjalanan perjalanan) {
        Bundle dataDaftarTiket = new Bundle();
        String namaPnmpng = et_namaPenumpang.getText().toString();
        String noKtpPnpmng = et_noKtp.getText().toString();
        int bayiId = 0;
        int perjalananId = perjalananDipesan.getId();

        dataDaftarTiket.putString("namaPenumpang", namaPnmpng);
        dataDaftarTiket.putString("noKtpPenumpang", noKtpPnpmng);
        dataDaftarTiket.putInt("bayiId", bayiId);
        dataDaftarTiket.putInt("perjalananId", perjalananId);

        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtras(dataDaftarTiket);
        intent.putExtra("perjalanan", (Serializable) perjalanan);
        
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void setPresenter(InputPesananContract.Presenter presenter) {

    }


}
