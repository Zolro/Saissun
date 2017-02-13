package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;





@XmlRootElement(name="xml")
public class TextMsg extends Msg{
		//@XmlElement(name="Content")	
	 	private String Content;
	/*	@XmlElement(name="ToUserName")
		private String ToUserName;
		@XmlElement(name="FromUserName")
	    private String FromUserName;
		@XmlElement(name="CreateTime")
	    private long CreateTime;
		@XmlElement(name="MsgType")
	    private String MsgType;*/
		
	    public TextMsg() {
	        super();
	    }
	    	
	    @XmlElement(name="Content")
	    @XmlCDATA
		public String getContent() {
			return Content;
		}

		public void setContent(String content) {
			Content = content;
		}

		
		
		
		
	
}
