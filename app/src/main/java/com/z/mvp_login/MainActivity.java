package com.z.mvp_login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.z.mvp_login.model.User;
import com.z.mvp_login.presenter.IPresenter;
import com.z.mvp_login.presenter.MainPresenter;

/*
    传统模式下
        activity|fragment既是v, 又是c

    mvp模式下
        activity|fragment只是v
        presenter负责v与m之间的交互

        v接收用户输入的数据
        v将数据交给p
        p直接操作m进行业务处理
        m将处理完成后通知p
        p通知v

    接口可以实现activity|fragment作为v的平滑切换，但是出现的问题是接口越来越多
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private ProgressDialog mProgressDialog;

    private IPresenter mPresenter;

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

        mPresenter = new MainPresenter(this);
    }

    @Override
    public void onClick(View view) {
        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        mPresenter.login(username, password);
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mProgressDialog.hide();
    }

    @Override
    public void loginSuccess(User user) {
        Toast.makeText(MainActivity.this, "登录成功: " + user, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailure() {
        Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
    }
}