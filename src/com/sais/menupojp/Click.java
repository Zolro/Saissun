package com.sais.menupojp;

public class Click extends Menu{
	private String key;

	public Click() {
		super();
		setType("click");
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Click [key=" + key + ", getKey()=" + getKey() + ", getType()="
				+ getType() + ", getName()=" + getName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
