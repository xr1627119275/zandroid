package com.xr.z_android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xr.z_android.R;
import com.xr.z_android.bean.NewsBean;

import java.util.ArrayList;

/**
 * Created by 16271 on 2018/3/4.
 */

public class NewsAdapter extends BaseAdapter{
    private final ArrayList<NewsBean> list;
    private final Context context;

    public NewsAdapter(Context context, ArrayList<NewsBean> list){
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if(convertView!=null){
            view = convertView;
        }else{
            view = view.inflate(context, R.layout.item_news_layout, null);
//            View view = .from(context).inflate(R.layout.item_news_layout, null);
//                    LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                    View view = layoutInflater.inflate(R.layout.item_news_layout, null);
            ImageView item_img_icon = view.findViewById(R.id.item_img_icon);
            TextView item_tv_title = view.findViewById(R.id.item_tv_title);
            TextView item_tv_des = view.findViewById(R.id.item_tv_des);
            NewsBean newsBean = list.get(position);
            item_img_icon.setImageDrawable(newsBean.icon);
            item_tv_title.setText(newsBean.title);
            item_tv_des.setText(newsBean.des);
        }
        return view;
    }
}
