package com.z.mvp_login.model;

public interface IModel {
    void login(String username, String password, ICallback callback);
}
