package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Detail2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
    }

    public void Click17(View view) {//私聊该用户
        //进入私聊页面
        //Toast.makeText(new Detail2Activity(),"进入私聊界面",Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(Detail2Activity.this,ChatActivity.class);
        startActivity(intent);
    }

    public void Click18(View view) {//进入到该用户的资料卡展示页面-MassageActivity2
        Intent intent =new Intent(Detail2Activity.this,Message2Activity.class);
        startActivity(intent);

    }

    public void Click20(View view) {//进入到该用户的资料卡展示页面-MassageActivity2
        Intent intent =new Intent(Detail2Activity.this,Message2Activity.class);
        startActivity(intent);
    }
}
