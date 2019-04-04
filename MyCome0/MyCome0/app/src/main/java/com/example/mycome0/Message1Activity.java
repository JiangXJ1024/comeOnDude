package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Message1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message1);
    }

    public void Click5(View view) {//查看动态--跳转至动态页面1


    }

    public void Click6(View view) {//修改信息--跳转至信息设置页面
        Intent intent =new Intent(Message1Activity.this,SetActivity.class);
        startActivity(intent);

    }
}
