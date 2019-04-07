package com.example.mycome0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mycome0.fragment.Con1Activity;
import com.example.mycome0.fragment.MLAdapter;
import com.example.mycome0.fragment.MyListAdapter;

public class LWActivity extends AppCompatActivity {

    private ListView mLv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lw);

        mLv1 = findViewById(R.id.List4);
        mLv1.setAdapter(new MLAdapter(this,null));

        mLv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LWActivity.this,"点击 pos:"+position,Toast.LENGTH_SHORT).show();
                //跳转到详情页
                if(true) {//自己的动态
                    Intent intent = new Intent(LWActivity.this, Detail1Activity.class);
                    startActivity(intent);
                }
                else{//其他人的动态
                    Intent intent = new Intent(LWActivity.this, Detail2Activity.class);
                    startActivity(intent);

                }
            }
        });
        mLv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LWActivity.this,"删除成功！长按 pos:"+position,Toast.LENGTH_SHORT).show();
                //删除
                return true;
            }
        });
    }

}
