package com.sais.msgpojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;
@XmlRootElement(name="xml")
public class MusicMsg extends Msg{
	private List<Music> Musics;
	
	
	public MusicMsg() {
		super();
		Musics=new ArrayList<>();
	}
			
	public void add(Music music){
		Musics.add(music);
    }
	
	@XmlElement(name="Music") 
	 @XmlCDATA
	public List<Music> getMusics() {
		return Musics;
	}

	public void setMusics(List<Music> musics) {
		Musics = musics;
	}
	
	
	



	
}
