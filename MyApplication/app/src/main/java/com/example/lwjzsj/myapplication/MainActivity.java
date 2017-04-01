package com.example.lwjzsj.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends Activity implements View.OnClickListener {
    Button msgSendBtn;
    EditText msgText;
    LinearLayout msgList;
    Button alertBtn,prograssBtn;
    ListView listView;
    private String[] data= {"aaaaaa","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd","bbbbb","ccccc","dddddd"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msgSendBtn = (Button)findViewById(R.id.msgSendBtn);
        msgText = (EditText)findViewById(R.id.msgText);
        alertBtn = (Button)findViewById(R.id.alertBtn);
        prograssBtn = (Button)findViewById(R.id.prograssBtn);
        listView = (ListView)findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = data[position];
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });

        msgSendBtn.setOnClickListener(this);

        alertBtn.setOnClickListener(this);

        prograssBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.msgSendBtn:
                TextView tv = new TextView(this);
                String str = msgText.getText().toString();
                if(str.length() > 1){
                    tv.setText(str);
                    msgList = (LinearLayout)findViewById(R.id.msgList);
                    msgList.addView(tv);
                    msgText.setText("");
                }else{
                    Toast.makeText(MainActivity.this,"发送内容不能为空",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.alertBtn:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("提示框");
                dialog.setMessage("弹窗提示 测试");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            case R.id.prograssBtn:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("提示框");
                progressDialog.setMessage("请稍后...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                break;
        }
    }
}
