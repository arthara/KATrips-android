package com.katripstask.katrips.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.katripstask.katrips.R;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.utils.UtilProvider;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {
    EditText etEmail;
    EditText etPassword;
    Button btnLogin;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_login, container, false);
        mPresenter = new LoginPresenter(this, new LoginInteractor(UtilProvider.getSharedPrefManager()));
        etEmail = fragmentView.findViewById(R.id.etEmail);
        etPassword = fragmentView.findViewById(R.id.etPassword);

        btnLogin = fragmentView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnLoginOnClick();
            }
        });

        return fragmentView;
    }

    private void setBtnLoginOnClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email, password);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(activity, LoginActivity.class);
        Toast.makeText(activity, "Login CUks", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void loginFailed(String failedMsg) {
        Toast.makeText(activity, failedMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {

    }
}
