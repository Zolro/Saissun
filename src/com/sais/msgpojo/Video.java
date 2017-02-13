package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlType(propOrder={"mediaId","title","description"})
public class Video {
	private String MediaId;
	private String Title;
	private String Description;
	public Video() {
		super();
	}
	@XmlElement(name="MediaId")
	@XmlCDATA
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	@XmlElement(name="Title")
	@XmlCDATA
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@XmlElement(name="Description")
	@XmlCDATA
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
