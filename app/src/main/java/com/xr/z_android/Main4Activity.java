package com.xr.z_android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xr.z_android.util.StreamUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class Main4Activity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "Main4Activity";
    private EditText et_url;
    private Button bt_looksource;
    private TextView tv_source;
    private ImageView img_inter;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        mContext = this;
        et_url = findViewById(R.id.et_url);
        bt_looksource = findViewById(R.id.bt_looksource);
//        tv_source = findViewById(R.id.tv_source);
        img_inter = findViewById(R.id.img_inter);
        bt_looksource.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                String url_str = et_url.getText().toString().trim();
                if (TextUtils.isEmpty(url_str)) {
                    Toast.makeText(mContext, "url为空", Toast.LENGTH_SHORT).show();
                    return ;
                } else {
                    try {
                        URL url = new URL(url_str);
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(2000 * 10);
                        int code = connection.getResponseCode();
                        if (code == 200) {
                            InputStream inputStream = connection.getInputStream();
//                            String result = StreamUtils.StreamToString(inputStream);
                            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                            inputStream.close();
                            Message message = new Message();
                            message.obj = bitmap;
                            mHandler.sendMessage(message);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bitmap bitmap = (Bitmap) msg.obj;
            img_inter.setImageBitmap(bitmap);
        }
    };
}

