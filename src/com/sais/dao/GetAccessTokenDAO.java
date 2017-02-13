package com.sais.dao;

import java.io.IOException;
import java.net.MalformedURLException;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;


//主动调用接口的方法
public interface GetAccessTokenDAO {

	public String getAccess()throws JSONException;//获取用户凭证
	
	public String AutoReplyRules()throws JSONException;
	
	//创建自定义菜单模块
	public String CreatMenu(JSONObject json) throws JSONException , IOException;
	//查询自定义菜单 也可查询全部的 个性化菜单
	public String SelectMenu() throws JSONException , IOException;
	//删除自定义菜单 也可删除个性化菜单
	public String DeleteMenu() throws JSONException , IOException;
	//创建个性化自定义菜单
	public String CreatAlityMenu(String creat) throws JSONException , IOException;
	public String DeleteAlityMenu(JSONObject json)throws JSONException , IOException;
	public String MatchAlityMenu(JSONObject json)throws JSONException,IOException;
	
}
