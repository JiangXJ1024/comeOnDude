package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.mycome0.fragment.Con1Activity;


public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //下拉列表框--选择所在院校
        String[] ctype = new String[]{"哈尔滨工业大学（威海）", "山东大学（威海）"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner = super.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);

    }


    public void Click0(View view) {//跳转到激活页面

        Intent intent =new Intent(LoginActivity.this,NewActivity.class);
                startActivity(intent);
    }


    public void Click1(View view) {//点击登录跳转到主页面
        Intent intent =new Intent(LoginActivity.this,Con1Activity.class);
                startActivity(intent);
    }
}
