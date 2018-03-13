package com.xr.z_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xr.z_android.bean.InfoBean;
import com.xr.z_android.dao.InfoDao;
import com.xr.z_android.db.BankOpenHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "-------MainActivity-------";
    private Button button;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.del).setOnClickListener(this);
        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.query).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        InfoDao infoDao = new InfoDao(mContext);
        switch (view.getId()) {
            case R.id.add:
                InfoBean infoBean = new InfoBean();
                infoBean.name = "张三";
                infoBean.phone = "1111";
                if (infoDao.add(infoBean)) {
                    Toast.makeText(mContext, "添加成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.del:
                infoDao.del("张三");
                break;
            case R.id.update:
                InfoBean infoBean2 = new InfoBean();
                infoBean2.phone = "2222";
                infoBean2.name = "张三";

                infoDao.update(infoBean2);
                break;
            case R.id.query:
                infoDao.query("张三");
                break;

        }
    }

    public void transtation(View view) {
        BankOpenHelper bankOpenHelper = new BankOpenHelper(mContext);
        SQLiteDatabase db = bankOpenHelper.getReadableDatabase();
        db.beginTransaction();
        try {
            db.execSQL("update account set money = money-200 where name=?;", new String[]{"李四"});
            db.execSQL("update account set money = money+200 where name=?;", new String[]{"张三"});
            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            db.close();
        }
    }
}
