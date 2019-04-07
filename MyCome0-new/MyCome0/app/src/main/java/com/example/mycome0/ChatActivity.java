package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    public void Click23(View view) {//返回上一界面


    }

    public void Click24(View view) {//进入到该用户的信息展示页
        Intent intent =new Intent(this,Message2Activity.class);
        startActivity(intent);

    }

    public void Click25(View view) {//发送信息


    }
}
