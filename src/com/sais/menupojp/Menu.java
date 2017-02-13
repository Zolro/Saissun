package com.sais.menupojp;

import net.sf.json.JSONObject;

public class Menu {
	private String type;
	private String name;
	
	public Menu() {
		super();
	}
	public String getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Menu [type=" + type + ", name=" + name + "]";
	}
	
}
