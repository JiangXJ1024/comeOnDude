package com.example.mycome0.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycome0.Detail1Activity;
import com.example.mycome0.Detail2Activity;
import com.example.mycome0.LWActivity;
import com.example.mycome0.LoginActivity;
import com.example.mycome0.NewActivity;
import com.example.mycome0.R;


public class FragmentA1 extends Fragment {

    //private TextView text1;
    //private ListView List1;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a1,container,false);

        listView = view.findViewById(R.id.List1);
        listView.setAdapter(new MLAdapter(getActivity(),null));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(),"点击 pos:"+position,Toast.LENGTH_SHORT).show();
                //跳转到详情页，需判断人员信息
                if(true){//自己的动态
                    Intent intent =new Intent(getActivity(),Detail1Activity.class);
                    startActivity(intent);
                }
                else {//其他人的动态
                    Intent intent =new Intent(getActivity(),Detail2Activity.class);
                    startActivity(intent);
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"长按 pos:"+position,Toast.LENGTH_SHORT).show();
                //删除or私聊

                ///测试  其他人的动态
                Intent intent =new Intent(getActivity(),Detail2Activity.class);
                startActivity(intent);
                return true;
            }
        });

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //text1=view.findViewById(R.id.title1);
        //List1=view.findViewById(R.id.List1);
    }
}
