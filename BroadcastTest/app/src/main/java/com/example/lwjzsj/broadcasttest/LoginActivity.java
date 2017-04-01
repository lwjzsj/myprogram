package com.example.lwjzsj.broadcasttest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by lwjzsj on 2017/4/1.
 */

public class LoginActivity extends BaseActivity {
    private EditText account;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
}
