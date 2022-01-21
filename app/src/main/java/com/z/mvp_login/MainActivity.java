package com.z.mvp_login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.z.mvp_login.model.Callback;
import com.z.mvp_login.model.MainModel;
import com.z.mvp_login.model.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private ProgressDialog mProgressDialog;
    private MainModel mMainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mEtUsername = findViewById(R.id.et_username);
        mEtPassword = findViewById(R.id.et_password);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(this);
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("请稍等...");
        mMainModel = new MainModel();
    }

    @Override
    public void onClick(View view) {

        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        mProgressDialog.show();
        mMainModel.login(username, password, new Callback() {
            @Override
            public void onSuccess(User user) {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "登录成功: " + user, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure() {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });

    }


}