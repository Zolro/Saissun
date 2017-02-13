package com.sais.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;










import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.sais.dao.CreateMenuDAO;
import com.sais.dao.GetAccessTokenDAO;
import com.sais.dao.GetMsgDAO;
import com.sais.dao.WxUserDAO;
import com.sais.dao.imp.CreateMenuDAOImp;
import com.sais.dao.imp.GetAccessTokenDAOImp;
import com.sais.dao.imp.GetMsgDAOImp;
import com.sais.dao.imp.WxUserDAOImp;
import com.sais.menupojp.Click;
import com.sais.menupojp.View;
import com.sais.servlet.WechatServlet;

public class ServletTest {

	public static void main(String[] args) throws JSONException, IOException {
		// TODO Auto-generated method stub
		//String openID="oIDN8wEE8xwKNSM6PjVLaZ66Lo0s";
		//WxUserDAO wx=new WxUserDAOImp();
		/*
	    GetAccessTokenDAO access=new GetAccessTokenDAOImp();
		WxUserDAO udi=new WxUserDAOImp();
		udi.insertWxUser("oIpJ-wunn_asbpndeg-nYqcwR_Q");*/
	/*	Click c=new Click();
		c.setName("活动记录");
		c.setKey("act");
		
		
		 JSONObject object = JSONObject.fromObject(c);
		 
		 System.out.println(object.toString());*/
	/*	JSONObject json=new JSONObject();
		JSONObject json2=new JSONObject();
		JSONObject sub=new JSONObject();
		JSONArray button=new JSONArray();
		JSONObject button2=new JSONObject();
		JSONArray arry=new JSONArray();
		JSONObject arry2=new JSONObject();
		json.put("type", "click");
		json.put("name","活动记录");
		json.put("key", "actlog");
		
		json2.put("type", "click");
		json2.put("name","今日福利");
		json2.put("key", "fl");
		arry.add(json2);
		arry.add(json);
		
		sub.put("sub_button", arry);
		button.add(sub);
		button.add(json2);
		button2.put("button", button);
		System.out.println(arry.toString());
		System.out.println(sub.toString());
		System.out.println(button.toString());
	    System.out.println(button2.toString());*/
		CreateMenuDAO cm=new CreateMenuDAOImp();
	/*	JSONArray all=new JSONArray();
		JSONObject geo=new JSONObject();//地理
		JSONArray geobody=new JSONArray();
		JSONObject geohead=new JSONObject();//地理
		JSONObject geoall=new JSONObject();//地理
		
		JSONObject me=new JSONObject();//关于我们
		JSONArray mebody=new JSONArray();
		JSONObject mehead=new JSONObject();//地理
		JSONObject meall=new JSONObject();//地理
		*/
		Click c=new Click();
		c.setName("活动记录");
		c.setKey("actlog");
	
		Click c1=new Click();
		c1.setName("世界观");
		c1.setKey("actlog");
		
		Click c2=new Click();
		c2.setName("内容赏析");
		c2.setKey("content");
		
		Click c3=new Click();
		c3.setName("关于我们");
		c3.setKey("about");	
		
		Click c4=new Click();
		c4.setName("你的建议");
		c4.setKey("advice");
		
		Click c5=new Click();
		c5.setName("每日一歌");
		c5.setKey("song");
		
		View v=new View();
		v.setName("灰机维基");
		v.setUrl("http://asoiaf.huiji.wiki/wiki/%E5%86%B0%E4%B8%8E%E7%81%AB%E4%B9%8B%E6%AD%8C%E4%B8%AD%E6%96%87%E7%BB%B4%E5%9F%BA");
				
		JSONArray menu=new JSONArray();
		menu.add(JSONObject.fromObject(c1));
		menu.add(JSONObject.fromObject(c2));
		menu.add(JSONObject.fromObject(v));
		JSONObject result=cm.CreateMenuSubButton("冰与火地理",menu);
		JSONArray bt=new JSONArray();
		bt.add(result);
		bt.add(v);
		bt.add(c3);		
		System.out.println(cm.CreateMenuButton(bt));
		
		/*JSONObject act=JSONObject.fromObject(c);
		
		JSONObject geo1=JSONObject.fromObject(c1);
		JSONObject geo2=JSONObject.fromObject(c2);
		JSONObject geo3=JSONObject.fromObject(v);		
		geobody.add(geo1);
		geobody.add(geo2);
		geobody.add(geo3);
		
		geohead.put("name","冰与火地理");
		geo.put("sub_button", geobody);
		
		
		geoall.putAll(geohead);
		geoall.putAll(geo);
		
		JSONObject me1=JSONObject.fromObject(c3);
		JSONObject me2=JSONObject.fromObject(c4);
		JSONObject me3=JSONObject.fromObject(c5);
		mebody.add(me1);
		mebody.add(me2);
		mebody.add(me3);
		me.put("sub_button", mebody);
		mehead.put("name","关于我们");
		
		meall.putAll(mehead);
		meall.putAll(me);
		
		all.add(act);
		all.add(geoall);
		all.add(meall);
		 
	 
	
		
		System.out.println(cm.CreateMenuButton(all));*/
		
		
		
		
		
		/*JSONObject json=new JSONObject();
		JSONObject obj=new JSONObject();
		obj.put("name","浙江");
		json.put("tag", obj);
		System.out.println(json.toString());*/
			//String str;
			/*		JSONObject json=new JSONObject();
				json.put("user_id","oIDN8wEE8xwKNSM6PjVLaZ66Lo0s");*/
				
					
					//str =access.SelectMenu();//wx.insertWxUser(openID);
				//str=access.MatchAlityMenu(json);
					//str=gm.AutoReplyRules();
					//System.out.println(udi.SelectAccountTag().toString());//str.toString());		
	}

}
