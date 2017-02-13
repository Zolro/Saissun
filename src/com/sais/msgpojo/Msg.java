package com.sais.msgpojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;







@XmlType(propOrder={"toUserName","fromUserName","createTime","msgType"})
public  class Msg{
	//@XmlElement(name="ToUserName")
	private String ToUserName;
	//@XmlElement(name="FromUserName")
    private String FromUserName;
	//@XmlElement(name="CreateTime")
    private long CreateTime;
	//==@XmlElement(name="MsgType")
    private String MsgType;
	
	public Msg() {
		super();
	}
	
	
	@XmlElement(name="ToUserName")
	@XmlCDATA
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	@XmlElement(name="FromUserName")
	@XmlCDATA
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	@XmlElement(name="CreateTime")
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}
	@XmlElement(name="MsgType")
	@XmlCDATA
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	
	
	
    
	
    
}
