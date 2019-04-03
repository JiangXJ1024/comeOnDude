package com.example.mycome0.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
//import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioGroup;
//import android.widget.Spinner;

import com.example.mycome0.BlankFragment1;
import com.example.mycome0.R;

import static com.example.mycome0.R.id.List1;

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

        LayoutInflater inflater = LayoutInflater.from(this);
        View view01 = inflater.inflate(R.layout.fragment_a1, null);
        mLv1 = view01.findViewById(R.id.List1);
        mLv1.setAdapter(new MyListAdapter(Con1Activity.this));

//        //活动时间-年
//        String[] ctype1 = new String[]{"2019"};
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype1);  //创建一个数组适配器
//        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner1 = super.findViewById(R.id.spinner1);
//        spinner1.setAdapter(adapter1);
//
//        //月
//        String[] ctype2 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype2);  //创建一个数组适配器
//        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner2 = super.findViewById(R.id.spinner2);
//        spinner2.setAdapter(adapter2);
//
//        //日
//        String[] ctype3 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
//        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype3);  //创建一个数组适配器
//        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner3 = super.findViewById(R.id.spinner3);
//        spinner3.setAdapter(adapter3);
//
//        //时
//        String[] ctype4 = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
//        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype4);  //创建一个数组适配器
//        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner4 = super.findViewById(R.id.spinner4);
//        spinner4.setAdapter(adapter4);
//
//        //分
//        String[] ctype5 = new String[]{"0","5","10","15","20","25","30","35","40","45","50","55"};
//        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype5);  //创建一个数组适配器
//        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner5 = super.findViewById(R.id.spinner5);
//        spinner5.setAdapter(adapter5);
//
//        //截止时间-年
//        String[] ctype6 = new String[]{"2019"};
//        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype6);  //创建一个数组适配器
//        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner6 = super.findViewById(R.id.spinner6);
//        spinner6.setAdapter(adapter6);
//
//        //月
//        String[] ctype7 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
//        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype7);  //创建一个数组适配器
//        adapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner7 = super.findViewById(R.id.spinner7);
//        spinner7.setAdapter(adapter7);
//
//        //日
//        String[] ctype8 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
//        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype8);  //创建一个数组适配器
//        adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner8 = super.findViewById(R.id.spinner8);
//        spinner8.setAdapter(adapter8);
//
//        //时
//        String[] ctype9 = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
//        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype9);  //创建一个数组适配器
//        adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner9 = super.findViewById(R.id.spinner9);
//        spinner9.setAdapter(adapter9);
//
//        //分
//        String[] ctype10 = new String[]{"0","5","10","15","20","25","30","35","40","45","50","55"};
//        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ctype10);  //创建一个数组适配器
//        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式
//
//        Spinner spinner10 = super.findViewById(R.id.spinner10);
//        spinner10.setAdapter(adapter10);

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
}
