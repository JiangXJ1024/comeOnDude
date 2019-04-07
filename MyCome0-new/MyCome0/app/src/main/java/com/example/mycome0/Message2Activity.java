package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Message2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message2);
    }

    public void Click7(View view) {//查看动态--跳转至动态页面2
        Intent intent =new Intent(Message2Activity.this,LWActivity.class);
        startActivity(intent);
}

    public void Click8(View view) {//私聊--跳转至两人私聊界面
        //Toast.makeText(new Message2Activity(),"进入私聊界面",Toast.LENGTH_SHORT).show();
        Intent intent =new Intent(Message2Activity.this,ChatActivity.class);
        startActivity(intent);
    }
}
