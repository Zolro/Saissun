package com.sais.msgpojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name="xml")
public class VideoMsg extends Msg {
	private List<Video> Videos;

	//private long MediaId;	
	
	public VideoMsg() {
		super();
	}
			
	 @XmlElement(name="Video") 
	public List<Video> getVideos() {
		return Videos;
	}
	public void setVideos(List<Video> videos) {
		Videos = videos;
	} 
	   
	    
	
	 	
	 	
	
}
