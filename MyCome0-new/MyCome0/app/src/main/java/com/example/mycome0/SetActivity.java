package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
    }

    public void Click3(View view) {//更改头像


    }

    public void Click4(View view) {//保存设置的个人信息，然后返回登录页面
        //提示信息已成功保存

        //如果未登录返回登录首页面
        Intent intent =new Intent(SetActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}
