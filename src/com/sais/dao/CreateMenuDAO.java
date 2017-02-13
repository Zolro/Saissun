package com.sais.dao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface CreateMenuDAO {
	public String CreateMenuButton(JSONArray CreateJSONObject);
	public  JSONObject CreateMenuSubButton(String MenuName,JSONArray MenuBodyInside);
	//public  JSONObject CreateMenuSubButtonHigh(String MenuName,Map<String,Object> ...maps );

}
