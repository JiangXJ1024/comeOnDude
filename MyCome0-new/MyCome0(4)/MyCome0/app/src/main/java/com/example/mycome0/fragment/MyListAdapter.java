package com.example.mycome0.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycome0.LWActivity;
import com.example.mycome0.R;

import java.util.List;
import java.util.Map;

public class MyListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public MyListAdapter(Context context,List<Map<String, Object>> data){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

//    private LayoutInflater layoutInflater;
//    private Context context;
//    public MLAdapter(Context context,List<Map<String, Object>> data){
//        this.context=context;
//        //this.data=data;
//        this.layoutInflater=LayoutInflater.from(context);
//    public MyListAdapter(Con1Activity context, List<Map<String, Object>> list) {
//        this.mContext = context;
//        mLayoutInflater = LayoutInflater.from(context);
//
//    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item2,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv2);
            holder.tvTitle = convertView.findViewById(R.id.tv_title2);
            holder.tvTime = convertView.findViewById(R.id.tv_time2);
            holder.tvContent = convertView.findViewById(R.id.tv_content2);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是昵称");
        holder.tvContent.setText("这是内容");
        holder.tvTime.setText("2019-4-2");
        //给imageView控件赋值
        Glide.with(mContext).load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1554284671&di=e445dc8a47c0fe9bd85fb37a5362a3b6&src=http://b-ssl.duitang.com/uploads/item/20182/21/2018221142159_MZ33z.jpeg").into(holder.imageView);
        return convertView;
    }
}
