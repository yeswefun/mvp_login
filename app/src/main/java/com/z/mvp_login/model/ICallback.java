package com.z.mvp_login.model;

public interface ICallback {

//    void onRequest();

    void onSuccess(User user);

    void onFailure();
}
