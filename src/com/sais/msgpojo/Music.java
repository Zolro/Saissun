package com.sais.msgpojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="music",uniqueConstraints = {@UniqueConstraint(columnNames="Title")})
@XmlType(propOrder={"title","description","musicUrl","HQMusicUrl","thumbMediaId"})
public class Music{
	private int pkey;
	private String Title;
	private String Description;
	private String MusicUrl;
	private String HQMusicUrl;	
	private String ThumbMediaId;
	public Music() {
		super();
	}
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@XmlTransient
	public int getPkey() {
		return pkey;
	}
	public void setPkey(int pkey) {
		this.pkey = pkey;
	}
	
	@Column
	@XmlElement(name="Title")
	@XmlCDATA
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	
	@Column
	@XmlElement(name="Description")
	@XmlCDATA
	public String getDescription() {
		return Description;
	}
	
	public void setDescription(String description) {
		Description = description;
	}
	
	
	@Column
	@XmlElement(name="MusicUrl")
	@XmlCDATA
	public String getMusicUrl() {
		return MusicUrl;
	}
	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}
	
	
	
	@Column
	@XmlElement(name="HQMusicUrl")
	@XmlCDATA
	public String getHQMusicUrl() {
		return HQMusicUrl;
	}
	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}
	@Column
	@XmlElement(name="ThumbMediaId")
	@XmlCDATA
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	
	
}
