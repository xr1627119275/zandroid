package com.xr.z_android.util;


import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;

public class SmsUtils {
	public static boolean backup_Sms_android(Context context){
		
		XmlSerializer xs = Xml.newSerializer();
		try {
			xs.setOutput(context.openFileOutput("backupsms.xml", 0), "utf-8");
			xs.startDocument("utf-8", true);
			xs.startTag(null, "Smss");
				xs.attribute(null, "id", "1");
				xs.startTag(null, "sms");
				xs.attribute(null, "id", "1-1");
				xs.text("haha");
				xs.endTag(null, "sms");
			xs.endTag(null, "Smss");
			xs.endDocument();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}

	public static List<String> restore_Sms_android(Context mContext) throws Exception, XmlPullParserException {
		XmlPullParser xp = Xml.newPullParser();
		AssetManager assets = mContext.getAssets();
		
		List<String> list = new ArrayList<String>();
		xp.setInput(assets.open("backupsms.xml"), "utf-8");
		int type = xp.getEventType();
		while (type!=XmlPullParser.END_DOCUMENT) {
			String currentTagName = xp.getName();
			switch (type) {
			case XmlPullParser.START_TAG:
				if(currentTagName.equals("sms")){
					list.add(xp.getAttributeValue(null,"id"));
					list.add(xp.nextText());
				}
				break;
			case XmlPullParser.END_TAG:
				break;
			}
			
				
			type=xp.next();
		}
		
		
		return list;
	}
}
