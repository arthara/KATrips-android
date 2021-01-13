package com.katripstask.katrips.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.katripstask.katrips.R;

public class BaseFragment<T extends FragmentActivity, U extends BasePresenter> extends Fragment {
    protected String title;
    protected T  activity;
    protected View fragmentView;
    protected U mPresenter;
    protected FragmentListener fragmentListener;

    protected void setTitle(String title){
         this.title = title;
         fragmentListener.setTittle(title);
    }

    protected String getTittle(){
        return title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        title = getResources().getString(R.string.app_name);
        setTitle(title);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (T) context;
        this.fragmentListener = (FragmentListener) context;
    }
}
