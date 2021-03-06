package com.example.young.mvptest.login;

import com.example.young.mvptest.common.ResponseListener;

/**
 * Created by YOUNG on 2018/2/4.
 */

public class LoginPresenter implements LoginPresenterContract {

    private static final String TAG = "LoginPresenter";

  /*  public void login(String userName, String password, OnResponseListener onResponseListener) {


        Log.i(TAG, "网络请求登陆");

        onResponseListener.onSuccess(new LoginResult());

    }*/

    public void login(String userName, String password, final LoginView loginView) {

        loginView.start();
        //网络请求，此处省略，onResponseListener为请求回调

        ResponseListener<LoginResult> onResponseListener = new ResponseListener<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (loginResult.success) {
                    //保存登陆信息
                    loginView.success();
                } else {
                    loginView.fail();
                }
            }

            @Override
            public void onError(RuntimeException e) {

                loginView.error();
            }

            @Override
            public void onComplete() {

            }
        };

    }


}
