package com.sais.msgpojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

@XmlRootElement(name="xml")
public class NewsMsg extends Msg {
	private List<News> Items;
	private int ArticleCount;
	//private long MediaId;	
	
	public NewsMsg() {
		super();
		Items=new ArrayList<>();
	}
	
	
	

   
	public void add(News news){
		Items.add(news);
    }
	
	 @XmlElement(name="ArticleCount") 
	public int getArticleCount() {
		return ArticleCount;
	}

	
	 @XmlElementWrapper(name="Articles")
	 @XmlElement(name="item") 
	 	@XmlCDATA
	public List<News> getItems() {
		return Items;
	}




	public void setItems(List<News> items) {
		Items = items;
	}




	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
		

	
			
	
	
	   
	    
	
	 	
	 	
	
}
