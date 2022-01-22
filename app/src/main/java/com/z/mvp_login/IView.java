package com.z.mvp_login;

import com.z.mvp_login.model.User;

public interface IView {

    void showProgressDialog();

    void hideProgressDialog();

    void loginSuccess(User user);

    void loginFailure();
}
