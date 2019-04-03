package com.example.administrator.nyllog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FRIEND extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        Toast.makeText(FRIEND.this,  ((MyApplication)FRIEND.this.getApplicationContext()).words, Toast.LENGTH_LONG).show();

        List <String> MyList=new ArrayList<String>();
        MyList.add("160400201");
        MyList.add("160400202");
        MyList.add("160400203");

        //String MyList[]= {"160400201", "160400202", "160400203", "160400305"};

        ListView ll = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> array = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,MyList);

        //将数据和布局 显示到列表
        ll.setAdapter(array);

        //设置listview点击事件
        ll.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent =new Intent(FRIEND.this,CHAT.class);
                        ((MyApplication)FRIEND.this.getApplicationContext()).sno=parent.getItemAtPosition(position).toString();
                        startActivity(intent);
                    }

                });
    }

}
