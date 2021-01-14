package com.katripstask.katrips.modul.checkout;

import com.katripstask.katrips.base.BasePresenter;
import com.katripstask.katrips.base.BaseView;
import com.katripstask.katrips.callback.RequestCallback;
import com.katripstask.katrips.model.User;

public interface CheckoutContract {
    interface View extends BaseView<Presenter> {
        void backToCariTiket();
    }

    interface Presenter extends BasePresenter{
        void redirectToCariTiket();
    }

    interface Interactor{
    }
}
