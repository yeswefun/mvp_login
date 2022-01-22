package com.z.mvp_login.presenter;

import com.z.mvp_login.IView;
import com.z.mvp_login.model.ICallback;
import com.z.mvp_login.model.IModel;
import com.z.mvp_login.model.MainModel;
import com.z.mvp_login.model.User;

/*
    presenter持有model与view，并协调两者的交互
 */
public class MainPresenter implements IPresenter, ICallback {

    private IView mMainView;
    private IModel mMainModel;

    public MainPresenter(IView mainView) {
        mMainModel = new MainModel();
        mMainView = mainView;
    }

    @Override
    public void login(String username, String password) {
        mMainView.showProgressDialog();
        mMainModel.login(username, password, this);
    }

    @Override
    public void onSuccess(User user) {
        mMainView.hideProgressDialog();
        mMainView.loginSuccess(user);
    }

    @Override
    public void onFailure() {
        mMainView.hideProgressDialog();
        mMainView.loginFailure();
    }
}
