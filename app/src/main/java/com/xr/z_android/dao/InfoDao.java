package com.xr.z_android.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.xr.z_android.bean.InfoBean;
import com.xr.z_android.db.MySqliteOpenHelper;

/**
 * Created by 16271 on 2018/3/4.
 */

public class InfoDao {

    private MySqliteOpenHelper sqliteOpenHelper;
    private Context context;

    public InfoDao(Context context) {
        sqliteOpenHelper = new MySqliteOpenHelper(context);
        this.context = context;
    }

    public boolean add(InfoBean infoBean) {
        SQLiteDatabase db = sqliteOpenHelper.getReadableDatabase();
//        db.execSQL("insert into _xr(name,phone) values(?,?);", new String[]{infoBean.name, infoBean.phone});
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", infoBean.name);
        contentValues.put("phone", infoBean.phone);
        long result = db.insert("_xr", "null", contentValues);
        db.close();
        if(result!=-1){
            return true;
        }else{
            return false;
        }

    }

    public int del(String name) {
        SQLiteDatabase db = sqliteOpenHelper.getReadableDatabase();
//        db.execSQL("delete from _xr where name=?;", new String[]{name});
        int result = db.delete("_xr", "name =?", new String[]{name});
        db.close();
        return result;
    }

    public int update(InfoBean infoBean) {
        SQLiteDatabase db = sqliteOpenHelper.getReadableDatabase();
//        db.execSQL("update _xr set phone=? where name=?;", new Object[]{infoBean.phone, infoBean.name});
        ContentValues contentValues = new ContentValues();
        contentValues.put("phone", infoBean.phone);
        int result= db.update("_xr", contentValues, "name = ?", new String[]{infoBean.name});


        db.close();
        return result;
    }

    public void query(String name) {
        SQLiteDatabase db = sqliteOpenHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery("select * from _xr where name =?;", new String[]{name});
        Cursor cursor = db.query("_xr", null, "name=?", new String[]{name}, null, null, null);
        if (cursor != null && cursor.getColumnCount() > 0) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(0);
                String name_str = cursor.getString(1);
                String phone = cursor.getString(2);
                Toast.makeText(context, "id=" + id + ",name=" + name_str + ",phone=" + phone, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(context, "没查到数据", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }


}
