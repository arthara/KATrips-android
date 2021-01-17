package com.katripstask.katrips.modul.login;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {
    LoginFragment loginFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        loginFragment =  new LoginFragment();
        setCurrentFragment(loginFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
