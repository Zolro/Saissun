package com.sais.menupojp;

public class ViewLimited extends Menu{
	private String MediaId;

	public ViewLimited() {
		super();
		setType("view_limited");
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	
}
