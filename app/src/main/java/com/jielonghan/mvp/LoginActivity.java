package com.jielonghan.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * view层对应的activity这里是登陆的activity
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText mUsername;
    private EditText mPassword;
    private Button mButton;
    private ProgressBar mProgress;
    private LoginPresenter persenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        persenter = new LoginPresenterImpl(this);
    }


    @Override
    protected void onDestroy() {
        persenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {

        mProgress.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        mProgress.setVisibility(View.GONE);
    }

    @Override
    public void setUesrnameError() {
        mUsername.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        mPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
        mProgress.setVisibility(View.GONE);
    }

    private void initView() {
        mUsername = (EditText) findViewById(R.id.username);
        mPassword = (EditText) findViewById(R.id.password);
        mButton = (Button) findViewById(R.id.button);
        mProgress = (ProgressBar) findViewById(R.id.progress);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                persenter.validateCredentials(mUsername.getText().toString(),mPassword.getText().toString());
                break;
        }
    }

}
