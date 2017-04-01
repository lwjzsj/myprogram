package com.example.lwjzsj.broadcasttest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lwjzsj on 2017/4/1.
 */

public class LoginActivity extends BaseActivity {
    private EditText accountText;
    private EditText passwordText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        accountText = (EditText)findViewById(R.id.account);
        passwordText = (EditText)findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountText.getText().toString();
                String password = passwordText.getText().toString();
                if((account == "admin") &&(password == "12345")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"密码或用户名不正确",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
