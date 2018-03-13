package com.xr.z_android.util;

import android.content.Context;

import com.xr.z_android.R;
import com.xr.z_android.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 16271 on 2018/3/4.
 */

public class NewsUtils {
    public static List<NewsBean> getAllNews(Context context) {
        ArrayList<NewsBean> arrayList = new ArrayList<NewsBean>();
        for(int i=0;i<100;i++) {
            NewsBean newsBean = new NewsBean();
            newsBean.title = "谢霆锋经纪人:偷拍系侵权行为";
            newsBean.des = "谢霆锋隐私权受到侵犯,将保留追究法律责任";
            newsBean.news_url = "http://www.sina.cn";
            newsBean.icon = context.getResources().getDrawable(R.drawable.ic_launcher_background);
            arrayList.add(newsBean);
            NewsBean newsBean2 = new NewsBean();
            newsBean2.title = "知情人:王菲是谢霆锋最爱的人";
            newsBean2.des = "身边的人都知道谢霆锋最爱王菲,二人早有复合迹象";
            newsBean2.news_url = "http://www.baidu.cn";
            newsBean2.icon = context.getResources().getDrawable(R.drawable.ic_launcher_background);
            arrayList.add(newsBean2);
        }
        return arrayList;
    }
}
