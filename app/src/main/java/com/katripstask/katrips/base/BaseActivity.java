package com.katripstask.katrips.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.katripstask.katrips.R;

public abstract class BaseActivity extends FragmentActivity implements FragmentListener {
    protected BaseFragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeFragment();
        initializeView();
    }

    protected abstract void initializeFragment();

    protected abstract void initializeView();

    protected void setCurrentFragment(BaseFragment fragment, boolean addToBackStack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(currentFragment != null && addToBackStack){
            fragmentTransaction.addToBackStack(currentFragment.getTittle());
        }

        fragmentTransaction.replace(R.id.flFragmentContainer, fragment, fragment.getTittle());
        fragmentTransaction.commit();

        this.currentFragment = fragment;
    }
}
