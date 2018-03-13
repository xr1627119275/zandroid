package com.xr.z_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private ListView lv;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mContext = this;
        lv = findViewById(R.id.lv);
        lv.setAdapter(new MyListAdapter());
    }

    class MyListAdapter extends BaseAdapter {
        public MyListAdapter(){

        }
        //告诉listview显示的条目
        @Override
        public int getCount() {
            return 20;
        }
        //根据postion
        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView textView = null;
            textView.setText("postion:"+position);
            textView.setTextSize(28);
            if(convertView!=null){
                textView = (TextView) convertView;
            }else{
                textView=new TextView(mContext);
            }
            return textView;
        }
    }
}
