package com.katripstask.katrips.modul.caritiket;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;
import com.katripstask.katrips.modul.login.LoginFragment;

public class CariTiketActivity extends BaseFragmentHolderActivity {
    CariTiketFragment cariTiketFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        cariTiketFragment =  new CariTiketFragment();
        setCurrentFragment(cariTiketFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
