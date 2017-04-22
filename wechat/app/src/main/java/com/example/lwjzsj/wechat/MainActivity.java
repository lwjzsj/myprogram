package com.example.lwjzsj.wechat;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView wechatBtn = (TextView)findViewById(R.id.wechat_btn);
        wechatBtn.setOnClickListener(this);
        TextView contactBtn = (TextView)findViewById(R.id.contact_btn);
        contactBtn.setOnClickListener(this);

    }
    public void onClick(View view){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.wechat_btn:
                WechatFragment fragment = new WechatFragment();
                fragmentTransaction.replace(R.id.layout_wechat_list_frag,fragment);
                fragmentTransaction.commit();
                break;
            case R.id.contact_btn:
                ContactFragment fragment1 = new ContactFragment();
                fragmentTransaction.replace(R.id.layout_wechat_list_frag,fragment1);
                fragmentTransaction.commit();
                break;

        }
    }
}
