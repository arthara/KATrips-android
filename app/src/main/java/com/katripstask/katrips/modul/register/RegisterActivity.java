package com.katripstask.katrips.modul.register;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;

public class RegisterActivity extends BaseFragmentHolderActivity {
    RegisterFragment registerFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        registerFragment =  new RegisterFragment();
        setCurrentFragment(registerFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
