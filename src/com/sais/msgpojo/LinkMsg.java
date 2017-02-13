package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name="xml")
@XmlType(propOrder={"title","description","url","msgId"})
public class LinkMsg extends Msg {
	private String Title;
	private String Description;
	private String Url;
	private int MsgId;
	public LinkMsg() {
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
	@XmlElement(name="Url")
    @XmlCDATA
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	@XmlElement(name="MsgId")
	public int getMsgId() {
		return MsgId;
	}
	public void setMsgId(int msgId) {
		MsgId = msgId;
	}
	
}
