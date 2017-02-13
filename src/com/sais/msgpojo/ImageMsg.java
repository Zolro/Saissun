package com.sais.msgpojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name="xml")
public class ImageMsg extends Msg {
	private String[] Image;
	//private long MediaId;	
	
	public ImageMsg() {
		super();
	}
	
	 
	/*@XmlElement(name="MediaId")
    @XmlCDATA
	public long getMediaId() {
		return MediaId;
	}
		public void setMediaId(long mediaId) {
		MediaId = mediaId;
	}
	*/
	 	@XmlElementWrapper(name="Image")  
	    @XmlElement(name="MediaId") 
	 	@XmlCDATA
	 	public String[] getImage() {
		return Image;
	}


	public void setImage(String[] image) {
		Image = image;
	}



	
}
