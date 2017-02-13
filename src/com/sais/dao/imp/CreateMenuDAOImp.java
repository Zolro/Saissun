package com.sais.dao.imp;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sais.dao.CreateMenuDAO;
import com.sais.menupojp.Menu;

public class CreateMenuDAOImp implements CreateMenuDAO{

	@Override
	public String CreateMenuButton(JSONArray CreateJSONObject) {
		// TODO Auto-generated method stub
		JSONObject button=new JSONObject();
		button.put("button", CreateJSONObject);
		return button.toString();
	}

	@Override
	public JSONObject CreateMenuSubButton(String MenuName,JSONArray MenuBodyInside) {
		// TODO Auto-generated method stub
		
		
		JSONObject MenuHead=new JSONObject();
		JSONObject MenuBody=new JSONObject();//地理
		JSONObject aMenu=new JSONObject();//地理
		
		MenuBody.put("sub_button", MenuBodyInside);		
		MenuHead.put("name",MenuName);
		aMenu.putAll(MenuHead);
		aMenu.putAll(MenuBody);
		
		return aMenu;
	}

	/*@Override
	public JSONObject CreateMenuSubButtonHigh(String MenuName, Map<String,Object>... maps) {
		// TODO Auto-generated method stub
		
		return null;
	}*/

}
