package com.katripstask.katrips.modul.pilihtiket;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;
import com.katripstask.katrips.modul.caritiket.CariTiketFragment;

public class PilihTiketActivity extends BaseFragmentHolderActivity {
    PilihTiketFragment pilihTiketFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        pilihTiketFragment =  new PilihTiketFragment();
        setCurrentFragment(pilihTiketFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
