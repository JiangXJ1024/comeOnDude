package com.example.administrator.nyllog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CHAT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        TextView t = (TextView) findViewById(R.id.textView);
        final EditText input=(EditText) findViewById(R.id.input_text);
        final ListView list = (ListView) findViewById(R.id.listview);


        t.setText("正在与"+((MyApplication)CHAT.this.getApplicationContext()).sno+"聊天");


        final List<String> MyList=new ArrayList<String>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MyList);
        //将数据和布局 显示到列表
        list.setAdapter(adapter);


        Button send=(Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //注：此部分代码为测试用
                String myword="我说： "+input.getText().toString();
                MyList.add(myword);
                //adapter.notifyDataSetChanged();//通知ListView，数据已发生改变
                //list.setSelection(list.getCount() - 1);//发送一条消息时，ListView显示选择最后一项
                input.setText("");

                String hisword="他说： "+((MyApplication)CHAT.this.getApplicationContext()).words;
                MyList.add(hisword);
                adapter.notifyDataSetChanged();//通知ListView，数据已发生改变
                list.setSelection(list.getCount() - 1);//发送一条消息时，ListView显示选择最后一项
            }
        });

    }


}




