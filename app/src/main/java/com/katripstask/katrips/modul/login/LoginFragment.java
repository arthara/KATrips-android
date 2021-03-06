package com.katripstask.katrips.modul.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.katripstask.katrips.R;
import com.katripstask.katrips.about_us;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.modul.caritiket.CariTiketActivity;
import com.katripstask.katrips.modul.register.RegisterActivity;
import com.katripstask.katrips.utils.UtilProvider;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {
    EditText etEmail;
    EditText etPassword;
    ImageButton btnLogin, btnRegister;
    ImageView btnAboutUs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_login, container, false);
        mPresenter = new LoginPresenter(this, new LoginInteractor(UtilProvider.getSharedPrefManager()));
        etEmail = fragmentView.findViewById(R.id.etEmail);
        etPassword = fragmentView.findViewById(R.id.etPassword);
        btnRegister = fragmentView.findViewById(R.id.btnDaftar);
        btnAboutUs = fragmentView.findViewById(R.id.iv_login_btnAboutUs);

        btnLogin = fragmentView.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnLoginOnClick();
            }
        });

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, about_us.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, RegisterActivity.class);
                startActivity(intent);
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
    public void loginSuccess(String token) {
        Intent intent = new Intent(activity, CariTiketActivity.class);
        Toast.makeText(activity, "Login Berhasil", Toast.LENGTH_SHORT).show();
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
