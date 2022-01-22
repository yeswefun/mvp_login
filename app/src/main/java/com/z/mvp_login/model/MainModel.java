package com.z.mvp_login.model;

import android.os.Handler;
import android.os.Looper;

/*
    进行数据访问，数据来源 本地磁盘|远程主机
 */
public class MainModel implements IModel {

    @Override
    public void login(String username, String password, ICallback callback) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                if (System.currentTimeMillis() % 2 == 0) {
                    callback.onSuccess(new User(username, password));
                } else {
                    callback.onFailure();
                }
            }
        }, 2000);
    }

}
