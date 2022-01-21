package com.z.mvp_login.model;

import android.os.Handler;
import android.os.Looper;

import com.z.mvp_login.model.Callback;
import com.z.mvp_login.model.User;

public class MainModel {

    public void login(String username, String password, Callback callback) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(new User(username, password));
            }
        }, 2000);
    }

}
