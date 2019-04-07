package com.example.mycome0.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycome0.R;

import java.util.List;
import java.util.Map;

public class MLAdapter extends BaseAdapter {

  //  private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public MLAdapter(Context context,List<Map<String, Object>> data){
        this.context=context;
        //this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public final class Zujian{
        public ImageView imageView;
        public TextView tvTitle,tvTime1,tvTime2,tvContent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.layout_list_item3, null);
            zujian.imageView=convertView.findViewById(R.id.head_image);
            zujian.tvTitle=convertView.findViewById(R.id.tv_title3);
            zujian.tvTime1=convertView.findViewById(R.id.time1);
            zujian.tvTime2=convertView.findViewById(R.id.time2);
            zujian.tvContent=convertView.findViewById(R.id.tv_content3);
            convertView.setTag(zujian);
        }else{
            zujian=(Zujian)convertView.getTag();
        }
        //绑定数据
        zujian.tvTitle.setText("发布人昵称");
        zujian.tvContent.setText("这是内容这是内容这是内容这是内容这是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容这里是内容");
        zujian.tvTime1.setText("2019-4-2");//发布时间
        zujian.tvTime2.setText("2019-4-4");//活动时间
        //给imageView控件赋值
        Glide.with(context).load("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1554284671&di=e445dc8a47c0fe9bd85fb37a5362a3b6&src=http://b-ssl.duitang.com/uploads/item/20182/21/2018221142159_MZ33z.jpeg").into(zujian.imageView);

        return convertView;
    }
}
