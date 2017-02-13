package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name="xml")
public class VoiceMsg extends Msg {
	private String[] Voice;
	//private long MediaId;	
	
	public VoiceMsg() {
		super();
	}
	 @XmlElementWrapper(name="Voice")  
	    @XmlElement(name="MediaId") 
	 	@XmlCDATA
	public String[] getVoice() {
		return Voice;
	}

	public void setVoice(String[] voice) {
		Voice = voice;
	}
	
}
