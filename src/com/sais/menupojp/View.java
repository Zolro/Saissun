package com.sais.menupojp;

public class View extends Menu {
	private String url;

	public View() {
		super();
		setType("view");
	}	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "View [url=" + url + ", getUrl()=" + getUrl() + ", getType()="
				+ getType() + ", getName()=" + getName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
