package com.xr.z_android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.xr.z_android.adapter.NewsAdapter;
import com.xr.z_android.bean.NewsBean;
import com.xr.z_android.util.NewsUtils;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener{
//
    private ListView lv;
    private Context mcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mcontext = this;
        lv = findViewById(R.id.listView);
        ArrayList<NewsBean> allNews = (ArrayList<NewsBean>) NewsUtils.getAllNews(mcontext);
        lv.setAdapter(new NewsAdapter(mcontext,allNews));
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsBean newsBean = (NewsBean) parent.getItemAtPosition(position);
        String url = newsBean.news_url;
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
