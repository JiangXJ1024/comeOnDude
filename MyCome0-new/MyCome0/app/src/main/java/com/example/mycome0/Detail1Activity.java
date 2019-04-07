package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Detail1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
    }

    public void Click15(View view) {//删除该条动态
        Toast.makeText(this,"删除成功！",Toast.LENGTH_SHORT).show();
        //返回动态详情页--需刷新，把已删除的动态去掉
//        Intent intent =new Intent(new Detail1Activity(),LWActivity.class);
//        startActivity(intent);
    }

    public void Click16(View view) {//进入自己的信息展示页-MassageActivity1
        Intent intent =new Intent(this,Message1Activity.class);
        startActivity(intent);

    }

    public void Click19(View view) {//进入自己的信息展示页-MassageActivity1
        Intent intent =new Intent(this,Message1Activity.class);
        startActivity(intent);
    }
}
