package com.example.mycome0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.mycome0.fragment.Con1Activity;
import com.example.mycome0.fragment.MyListAdapter;

public class LWActivity extends AppCompatActivity {

    private ListView mLv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lw);

        //LayoutInflater inflater = LayoutInflater.from(this);
        //View view01 = inflater.inflate(R.layout.fragment_a3, null);
        //mLv1 = findViewById(R.id.List22);
        //mLv1.setAdapter(new MyListAdapter(LWActivity.this));
    }
}
