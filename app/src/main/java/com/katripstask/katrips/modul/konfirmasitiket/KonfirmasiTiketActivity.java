package com.katripstask.katrips.modul.konfirmasitiket;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;

public class KonfirmasiTiketActivity extends BaseFragmentHolderActivity {
    KonfirmasiTiketFragment konfirmasiTiketFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        konfirmasiTiketFragment =  new KonfirmasiTiketFragment();
        setCurrentFragment(konfirmasiTiketFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
