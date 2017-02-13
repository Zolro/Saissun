package com.sais.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
//消息处理类
public interface GetMsgDAO {
	/*
	 * 设计流程初步
	 * 先完善基础功能模块：1C搭建用户自定义菜单
	 * 用户流程模式：
	 * */
	public String msg(Map map);//消息处理A
	public String ifError(Map map);//消息处理 子方法D
	
	
}
