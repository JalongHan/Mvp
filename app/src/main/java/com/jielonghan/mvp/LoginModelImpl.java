package com.jielonghan.mvp;


import android.os.Handler;
import android.text.TextUtils;

/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃    神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * 作者:jalong Han
 * 邮箱:hjl999@126.com
 * 时间:17/3/27
 * 功能:
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedLister lister) {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;

                if (TextUtils.isEmpty(username)){
                    lister.onUserNameError();
                    error = true;
                }

                if (TextUtils.isEmpty(password)){
                    lister.onPassWordError();
                    error = true;
                }

                if (!error){

                    lister.onSuccess();

                }



            }
        },2000);

    }
}
