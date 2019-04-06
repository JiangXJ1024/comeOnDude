package com.example.mycome0.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycome0.R;

import static android.widget.RadioGroup.*;

public class FragmentA2 extends Fragment {
    private TextView text1;
    private RadioGroup nRg1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //text1=view.findViewById(R.id.title1);

        //活动时间-年
        String[] ctype1 = new String[]{"2019"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ctype1);  //创建一个数组适配器
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner1 = view.findViewById(R.id.spinner1);
        spinner1.setAdapter(adapter1);

        Spinner spinner6 = view.findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter1);

        //月
        String[] ctype2 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ctype2);  //创建一个数组适配器
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner2 = view.findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter2);

        Spinner spinner7 = view.findViewById(R.id.spinner7);
        spinner7.setAdapter(adapter2);

        //日
        String[] ctype3 = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ctype3);  //创建一个数组适配器
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner3 = view.findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter3);

        Spinner spinner8 = view.findViewById(R.id.spinner8);
        spinner8.setAdapter(adapter3);

        //时
        String[] ctype4 = new String[]{"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ctype4);  //创建一个数组适配器
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner4 = view.findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter4);

        Spinner spinner9 = view.findViewById(R.id.spinner9);
        spinner9.setAdapter(adapter4);

        //分
        String[] ctype5 = new String[]{"0","5","10","15","20","25","30","35","40","45","50","55"};
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, ctype5);  //创建一个数组适配器
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     //设置下拉列表框的下拉选项样式

        Spinner spinner5 = view.findViewById(R.id.spinner5);
        spinner5.setAdapter(adapter5);

        Spinner spinner10 = view.findViewById(R.id.spinner10);
        spinner10.setAdapter(adapter5);


        nRg1 = view.findViewById(R.id.rg_1);
        nRg1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                //Toast.makeText(radioButton.getText(), FragmentA2.this, Toast.LENGTH_SHORT).show();
            }

        } );



    }
}
