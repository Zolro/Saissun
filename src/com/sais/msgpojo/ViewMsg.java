package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name="xml")
public class ViewMsg extends Msg {
	private String Event;
	private String EventKey;
	public ViewMsg() {
		super();
	}
	 @XmlElement(name="Event")
	    @XmlCDATA
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	 @XmlElement(name="EventKey")
	    @XmlCDATA
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	
}
