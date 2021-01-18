package com.katripstask.katrips.modul.register;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.katripstask.katrips.R;
import com.katripstask.katrips.about_us;
import com.katripstask.katrips.base.BaseFragment;
import com.katripstask.katrips.modul.caritiket.CariTiketActivity;
import com.katripstask.katrips.modul.login.LoginActivity;
import com.katripstask.katrips.request.RegisterUserRequest;
import com.katripstask.katrips.utils.UtilProvider;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterFragment extends BaseFragment<RegisterActivity, RegisterContract.Presenter> implements RegisterContract.View {
    EditText etNama, etAlamat, etTglLahir, etEmail, etPassword, etPasswordConfirmation;
    ImageButton btnLogin, btnRegister;
    Calendar tglBerangkat;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.activity_register, container, false);
        mPresenter = new RegisterPresenter(this, new RegisterInteractor(UtilProvider.getSharedPrefManager()));
        initView();
        datePickerListener();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBtnRegisterOnClick();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setBtnLoginOnClick();
            }
        });
        return fragmentView;
    }

    private void setBtnLoginOnClick(){
        mPresenter.redirectToLogin();
    }

    private void setBtnRegisterOnClick(){
        String nama = etNama.getText().toString();
        String alamat = etAlamat.getText().toString();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tglLahir = dateFormat.format(tglBerangkat.getTime());
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        String passwordConfirmation = etPasswordConfirmation.getText().toString();
        mPresenter.performRegister(new RegisterUserRequest(nama, email, password, passwordConfirmation, alamat, tglLahir));
    }

    private void initView(){
        etNama = fragmentView.findViewById(R.id.register_etNama);
        etAlamat = fragmentView.findViewById(R.id.register_etAlamat);
        etTglLahir = fragmentView.findViewById(R.id.register_tglLahir);
        etEmail = fragmentView.findViewById(R.id.register_etEmail);
        etPassword = fragmentView.findViewById(R.id.register_etPassword);
        etPasswordConfirmation = fragmentView.findViewById(R.id.register_etPasswordConfirmation);
        btnLogin = fragmentView.findViewById(R.id.register_btnLogin);
        btnRegister = fragmentView.findViewById(R.id.register_btnDaftar);
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {

    }

    private void datePickerListener(){
        // Edit Text Date Picker Listener
        final Calendar mCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, month);
                mCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel(mCalendar);
                tglBerangkat = mCalendar;
            }
        };
        etTglLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(activity, date,
                        mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH),
                        mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void updateLabel(Calendar mCalendar){
        String myFormat = "dd-M-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        etTglLahir.setText(sdf.format(mCalendar.getTime()));
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(activity, "Daftar akun Berhasil", Toast.LENGTH_SHORT).show();
        mPresenter.redirectToLogin();
    }

    @Override
    public void registerFailed(String failedMsg) {
        Toast.makeText(activity, failedMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginPage() {
        Intent intent = new Intent(activity, LoginActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
