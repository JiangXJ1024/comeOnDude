package com.example.mycome0.fragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
//import android.widget.Spinner;

import com.example.mycome0.Message1Activity;
import com.example.mycome0.R;

public class Con1Activity extends AppCompatActivity  {

    private FragmentA1 fragmentA1;
    private FragmentA2 fragmentA2;
    private FragmentA3 fragmentA3;
    private RadioGroup nRg1;
    private ListView mLv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con1);

        //实例化Fragment1
        fragmentA1=new FragmentA1();
        //Fragment1把添加到Activity中
        getSupportFragmentManager().beginTransaction().add(R.id.frame1,fragmentA1).commitAllowingStateLoss();

    }

    public void Click9(View view) {//点击广场，打开广场页
        if (fragmentA1 == null) {
            fragmentA1=new FragmentA1();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmentA1).commitAllowingStateLoss();

    }

    public void Click10(View view) {//点击发布，打开发布页
        if (fragmentA2 == null) {
            fragmentA2=new FragmentA2();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmentA2).commitAllowingStateLoss();
    }

    public void Click11(View view) {//点击消息，打开消息页
        if (fragmentA3 == null) {
            fragmentA3=new FragmentA3();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmentA3).commitAllowingStateLoss();

    }

    public void Click12(View view) {//取消发布，返回广场页
        if (fragmentA1 == null) {
            fragmentA1=new FragmentA1();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.frame1, fragmentA1).commitAllowingStateLoss();
    }

    public void Click13(View view) {//点击发布--发布动态
        //核验日期是否符合规定：年月日是否正确，时间先后是否有问题


    }

    public void Click14(View view) {//"我的"，跳转到资料展示页面
        Intent intent =new Intent(Con1Activity.this,Message1Activity.class);
        startActivity(intent);
    }
}
