package com.katripstask.katrips.modul.inputpesanan;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;

public class InputPesananActivity extends BaseFragmentHolderActivity {
    InputPesananFragment inputPesananFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        inputPesananFragment =  new InputPesananFragment();
        setCurrentFragment(inputPesananFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
