package com.katripstask.katrips.modul.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.katripstask.katrips.R;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.model.Perjalanan;
import com.katripstask.katrips.modul.caritiket.CariTiketActivity;
import com.katripstask.katrips.request.TiketRequest;
import com.katripstask.katrips.utils.UtilProvider;

public class CheckoutFragment extends BaseFragment<CheckoutActivity, CheckoutContract.Presenter> implements CheckoutContract.View {
    TextView tvPesanTerimaKasih, tvNoPesanan;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        super.onCreateView(inflater, container, savedInstanceState);
//        fragmentView = inflater.inflate(R.layout.activity_Checkout, container, false);
//        mPresenter = new CheckoutPresenter(this, new CheckoutInteractor(UtilProvider.getSharedPrefManager()));
//        initView();
//
//        btnCheckout = fragmentView.findViewById(R.id.btnCheckout);
//        btnCheckout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setBtnCheckoutOnClick();
//            }
//        });

        return fragmentView;
    }

//    private void initView(){
//        tvPesanTerimaKasih = fragmentView.findViewById(R.id.tvPesanTerimaKasih);
//        tvNoPesanan = fragmentView.findViewById(R.id.tvNoPesanan);
//    }

    private void setInitView(){
        tvPesanTerimaKasih.setText("TERIMA KASIH ATAS PESANAN ANDA");
        tvNoPesanan.setText("NO. PESANANAN " + getActivity().getIntent().getIntExtra("invoce", 0));
    }

    private void setBtnHomeOnClick(){
        mPresenter.redirectToCariTiket();
    }
        
    @Override
    public void backToCariTiket(){
        Intent intent = new Intent(activity, CariTiketActivity.class); // CHeckOUt Activity belum ada
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void setPresenter(CheckoutContract.Presenter presenter) {

    }
}
