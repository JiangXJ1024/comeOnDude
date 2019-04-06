package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //下拉列表框--选择所在院校
        String[] ctype = new String[]{"哈尔滨工业大学（威海）", "山东大学（威海）"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype);  //创建一个数组适配器
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner = super.findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
    }

    public void Click2(View view) {//激活账号-验证信息
        //如果信息验证正确，进入信息设置页
        Intent intent =new Intent(NewActivity.this,SetActivity.class);
        startActivity(intent);
        //如果验证信息有问题，提示信息错误
        //
    }
}
