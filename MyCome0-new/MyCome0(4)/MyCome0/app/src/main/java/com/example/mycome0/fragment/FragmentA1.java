package com.example.mycome0.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
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
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //text1=view.findViewById(R.id.title1);
        //List1=view.findViewById(R.id.List1);
    }
}
