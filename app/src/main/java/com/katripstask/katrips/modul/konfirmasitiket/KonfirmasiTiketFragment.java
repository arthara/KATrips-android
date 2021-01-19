package com.katripstask.katrips.modul.konfirmasitiket;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.katripstask.katrips.MainActivity;
import com.katripstask.katrips.R;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Penumpang;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.model.User;
import com.katripstask.katrips.modul.checkout.CheckoutActivity;
import com.katripstask.katrips.request.PesanTiketRequest;
import com.katripstask.katrips.utils.UtilProvider;

import java.util.List;

public class KonfirmasiTiketFragment extends BaseFragment<KonfirmasiTiketActivity, KonfirmasiTiketContract.Presenter> implements KonfirmasiTiketContract.View {
    // Detail Pesanan
    TextView tvTotalHarga, tvDetailPenumpang, tvDetailHarga;
    // Detail Perjalanan
    TextView tv_kodeStasiunAsal, tv_kodeStasiunTujuan, tv_jamKeberangkatan;
    TextView tv_jamTiba, tv_kelas, tv_kereta, tv_durasi, tv_hargaTiket;
    TextView tv_tanggalKeberangkatan, tv_detailPenumpang, tv_tglKeberangkatan;
    // Detail User
    TextView tv_namaUser, tv_emailUser;
    // Footer Component
    FloatingActionButton btnCheckout;

    ImageView iv_btnHome, iv_btBack;
    BottomAppBar bottomAppBarMenu;

    Perjalanan perjalanan;
    List<Penumpang> penumpangs;
    User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.detailpembayaran, container, false);
        mPresenter = new KonfirmasiTiketPresenter(this, new KonfirmasiTiketInteractor(UtilProvider.getSharedPrefManager()));
        initView();
        setInitView();

        btnCheckout = fragmentView.findViewById(R.id.btn_cariTiket);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnKonfirmasiTiketOnClick();
            }
        });

        iv_btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setResult(activity.RESULT_CANCELED);
                activity.finish();
            }
        });

        bottomAppBarMenu.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.btmAppBarItem_logout){
                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("logout", true);
                    activity.setResult(activity.RESULT_OK, returnIntent);
                    activity.finish();
                }
                return false;
            }
        });

        iv_btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("home", true);
                activity.setResult(activity.RESULT_OK, returnIntent);
                activity.finish();
            }
        });


        return fragmentView;
    }

    private void initView(){
        tvTotalHarga = fragmentView.findViewById(R.id.tv_detailPembayaran_totalHarga);
        tvDetailPenumpang = fragmentView.findViewById(R.id.tv_detailPembayaran_detialPenumpang);
        tvDetailHarga = fragmentView.findViewById(R.id.tv_detailPembayaran_detailHarga);

        tv_kodeStasiunAsal = fragmentView.findViewById(R.id.tv_detailPembayaran_stasiunAwal);
        tv_kodeStasiunTujuan = fragmentView.findViewById(R.id.tv_detailPembayaran_stasiunTujuan);
        tv_jamKeberangkatan = fragmentView.findViewById(R.id.tv_detailPembayaran_waktuBerangkat);
        tv_jamTiba = fragmentView.findViewById(R.id.tv_detailPembayaran_waktuTiba);
        tv_kereta = fragmentView.findViewById(R.id.tv_detailPembayaran_kereta);
        tv_kelas = fragmentView.findViewById(R.id.tv_detailPembayaran_kelas);
        tv_durasi = fragmentView.findViewById(R.id.tv_detailPembayaran_durasiPerjalanan);
        tv_hargaTiket  = fragmentView.findViewById(R.id.tv_detailPembayaran_harga);
        tv_tanggalKeberangkatan = fragmentView.findViewById(R.id.tv_detailPembayaran_waktuBerangkat);
        //tv_detailPenumpang = fragmentView.findViewById(R.id.tv_detailPembayaran_detialPenumpang);
        tv_namaUser = fragmentView.findViewById(R.id.tv_detailPembayaran_username);
        tv_emailUser = fragmentView.findViewById(R.id.tv_detailPembayaran_useremail);

        iv_btBack = fragmentView.findViewById(R.id.iv__detailPembayaran_backBtn);
        iv_btnHome = fragmentView.findViewById(R.id.btmAppBar_home);
        bottomAppBarMenu = fragmentView.findViewById(R.id.btmAppBar_menu);
    }

    private void setInitView(){
        perjalanan = (Perjalanan) getActivity().getIntent().getSerializableExtra("perjalanan");
        penumpangs = (List<Penumpang>) getActivity().getIntent().getSerializableExtra("penumpangs");
        user = (User) getActivity().getIntent().getSerializableExtra("user");
        tv_kodeStasiunAsal.setText(perjalanan.getLokasiBerangkat().getKode());
        tv_kodeStasiunTujuan.setText(perjalanan.getLokasiTiba().getKode());
        tv_jamKeberangkatan.setText(perjalanan.getWaktuBerangkat(false));
        tv_jamTiba.setText(perjalanan.getWaktuTiba(false));
        tv_kelas.setText(perjalanan.getKelas());
        tv_kereta.setText(perjalanan.getKereta());
        tv_durasi.setText("1 Jam 30 menit");
        tv_hargaTiket.setText(perjalanan.getHarga()+"");
        tv_tanggalKeberangkatan.setText(perjalanan.getWaktuBerangkat(true));
        //tv_detailPenumpang.setText("2 Dewasa, 1 Bayi");

        tv_namaUser.setText(user.getNama());
        tv_emailUser.setText(user.getEmail());

        iv_btnHome = fragmentView.findViewById(R.id.btmAppBar_home);
        bottomAppBarMenu = fragmentView.findViewById(R.id.btmAppBar_menu);

        tvTotalHarga.setText("Rp. " + perjalanan.getHarga()); // harga perjalanan dikali jmlh Penumpang DWS
        tvDetailHarga.setText(penumpangs.size() + " X " + perjalanan.getHarga()); // Rumus, butuh Intent dari CariTiket

        int jmlhPenumpangDws = 0;
        for(int i=0; i<penumpangs.size(); i++){
            if(penumpangs.get(i).getIsDewasa()) jmlhPenumpangDws++;
        }

        tvDetailPenumpang.setText("Dewasa x " + jmlhPenumpangDws ); // Intent dari Cari Tiket
        //tv_kategori.setText("Kategori"); // dari jmlh Penumpang dan kategori dari Intent Cari Tiket
    }

    private void setBtnKonfirmasiTiketOnClick(){
        final List<Penumpang> penumpangs = (List<Penumpang>) getActivity().getIntent().getSerializableExtra("penumpangs");
        mPresenter.pesanTiket(new PesanTiketRequest(penumpangs, perjalanan.getId()));
    }
    
    @Override
    public void checkOut(String response){
        Toast.makeText(activity, response, Toast.LENGTH_LONG).show();
//        Intent intent = new Intent(activity, MainActivity.class); // CHeckOUt Activity belum ada
//        intent.putExtra("invoce", kodePembayaran);
//        startActivity(intent);
//        activity.finish();
    }
        
    @Override
    public void backToInputPesanan(String failedMsg){
        Toast.makeText(activity, failedMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setPresenter(KonfirmasiTiketContract.Presenter presenter) {

    }
}
