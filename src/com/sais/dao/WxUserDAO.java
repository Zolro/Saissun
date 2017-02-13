package com.sais.dao;







import java.net.MalformedURLException;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.sais.pojo.WeChatUser;

public interface WxUserDAO {
	public String insertWxUser(String OpenId);
	public void DeleteWxUser();
	public void SelectWxUserByOpenID(String OpenID);
	public void SelectWxUserListByOpenID(JSONObject OpenIDListMayAddLanguage);
	public JSONObject SelectWxUserAtAccount(String OpenID);
	public void UpdateWxUserByID(String ID);
	
	
	public JSONObject CreateWxUserTag(JSONObject tagMap)throws JSONException, MalformedURLException;
	public JSONObject SelectAccountTag();
	public JSONObject UpdateWxUserTag(JSONObject tagMap);
	public JSONObject DeleteWxUserTag(JSONObject tagidlist);
	public JSONObject FindWxUserByTag(JSONObject tagid);
	//标签功能目前支持公众号为用户打上最多三个标签
	//批量操作
	public JSONObject CreateWxUserTagForMore(JSONObject OpenIDListAndTagID);
	public JSONObject DeleteWxUserTagForMore(JSONObject OpenIDListAndTagID);
	public JSONObject GetWxUserTagList(JSONObject OpenID);
	
	public JSONObject CreateWxUserNoteName(JSONObject OpenidandNoteName);
	
	public String CreateWxUserLocation(Map map);
	
}
