package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlType(propOrder={"title","description","picUrl","url"})
public class News {
	private String Title;
	private String Description;
	private String PicUrl;
	private String Url;
	public News() {
		super();
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
	@XmlElement(name="PicUrl")
	@XmlCDATA
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	@XmlElement(name="Url")
	@XmlCDATA
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	@Override
	public String toString() {
		return "News [Title=" + Title + ", Description=" + Description
				+ ", PicUrl=" + PicUrl + ", Url=" + Url + "]";
	}	
	
}
