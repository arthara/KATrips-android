package com.katripstask.katrips.modul.checkout;

import com.katripstask.katrips.base.BaseFragmentHolderActivity;

public class CheckoutActivity extends BaseFragmentHolderActivity {
    CheckoutFragment checkoutFragment;

    @Override
    protected void initializeFragment() {
        initializeView();

        checkoutFragment =  new CheckoutFragment();
        setCurrentFragment(checkoutFragment, false);
    }

    @Override
    public void setTittle(String tittle) {

    }
}
