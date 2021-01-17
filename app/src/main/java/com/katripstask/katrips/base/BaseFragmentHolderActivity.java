package com.katripstask.katrips.base;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.katripstask.katrips.R;

public abstract class BaseFragmentHolderActivity extends BaseActivity{
    protected FrameLayout flFragmentContainer;
    protected RelativeLayout rlActivityFragmentHolder;

    @Override
    protected void initializeView() {
        setContentView(R.layout.base_activity);
        flFragmentContainer = (FrameLayout) findViewById(R.id.flFragmentContainer);
        rlActivityFragmentHolder = (RelativeLayout) findViewById(R.id.rlActivityFragmentHolder);
    }

}
