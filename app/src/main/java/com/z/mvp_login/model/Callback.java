package com.z.mvp_login.model;

public interface Callback {

//    void onRequest();

    void onSuccess(User user);

    void onFailure();
}
