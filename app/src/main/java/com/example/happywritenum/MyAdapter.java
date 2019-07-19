package com.example.happywritenum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by 李利红 on 2019/5/29.
 */

public class MyAdapter extends BaseAdapter {
    //创建一个上下文，视图填充器
    private Context context;
    private LayoutInflater layoutInflater;
    //构造函数
    public MyAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    //获取列表数量
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    //获取视图
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //填充视图
        view = layoutInflater.inflate(R.layout.grid_list,viewGroup,false);
        //声明视图中的控件
        ImageView imageView = (ImageView)view.findViewById(R.id.iv_grid);
        //设置图片资源
        //设置内容
        if(i==0){
            imageView.setImageResource(R.drawable.on1_24);
        }
        if(i==1){
            imageView.setImageResource(R.drawable.on2_24);
        }
        if(i==2){
            imageView.setImageResource(R.drawable.on3_24);
        }
        if(i==3){
            imageView.setImageResource(R.drawable.on4_24);
        }
        if(i==4){
            imageView.setImageResource(R.drawable.on5_24);
        }
        if(i==5){
            imageView.setImageResource(R.drawable.on6_24);
        }
        if(i==6){
            imageView.setImageResource(R.drawable.on7_24);
        }
        if(i==7){
            imageView.setImageResource(R.drawable.on8_24);
        }
        if(i==8){
            imageView.setImageResource(R.drawable.on9_24);
        }
        if(i==9){
            imageView.setImageResource(R.drawable.on0_24);
        }
        return view;
    }
}
