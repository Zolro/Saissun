package com.sais.dao.imp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import net.sf.json.JSONObject;

import com.sais.dao.TypeOfReplyDAO;
import com.sais.msgpojo.LinkMsg;
import com.sais.msgpojo.Music;
import com.sais.msgpojo.MusicMsg;
import com.sais.msgpojo.News;
import com.sais.msgpojo.NewsMsg;
import com.sais.msgpojo.TextMsg;
import com.sais.msgpojo.ViewMsg;
import com.sais.util.XMLUtil;

public class TypeOfReplyDAOImp implements TypeOfReplyDAO,Serializable{
	private  SessionFactory sessionFactory;//会话工厂，用于创建会话
	private Session session;//hibernate会话
	private Transaction transaction; //hiberante事务
	private StandardServiceRegistry registry;
	private Configuration cfg;
	
	
	public TypeOfReplyDAOImp() {
		super();
		registry = new StandardServiceRegistryBuilder()
		.configure() // configures settings from hibernate.cfg.xml
		.build();
		cfg=new Configuration().configure();
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
	}

	@Override
	public String TextReply(Map map, String txt) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public String LinkReply(Map map, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String onClick(Map map, String clickword) {
		// TODO Auto-generated method stub
		System.out.println("==================================++++++++++++++++++++++++++++");
		String result = null;
		switch(clickword){
		 case "actlog":
			 onClickActlog(map);
			 break;
		 case "world":
		 	onClickWorld(map);
		 	break;
		 case "content":
			 onClickContent(map);
		 	break;
		 case "about":
			 result=onClickAbout(map);
		 	break;	
		 case "advice":
			 onClickAdvice(map);
		 	break;
		 case "song":
			 result=onClickSong(map);
		 	break;		
		 }
		return result;
	}
	public String onClickActlog(Map map) {
		return null;
		
	}
	public String onClickWorld(Map map){
		return null;
		
	}
	public String onClickContent(Map map) {
		return null;
		
	}
	
	public String onClickAbout(Map map) {		
		News news=new News();
		news.setTitle("关于我们");
		StringBuffer buffer = new StringBuffer();
		buffer.append("一个今天胜似两个明天").append("\n\n");
		buffer.append("\t\t\t\t\t");
		buffer.append("——").append("囧.我永远是副死人脸.雪诺");
		news.setDescription(buffer.toString());
		news.setPicUrl("http://img1.imgtn.bdimg.com/it/u=3724087400,814221825&fm=11&gp=0.jpg");
		news.setUrl("http://5d13ad2c.ngrok.natapp.cn/Saissun/card/index.html");
		List<News> items=new ArrayList<News>();
		items.add(news);
		NewsMsg newsMsg=new NewsMsg();
		newsMsg.setToUserName((String)map.get("FromUserName"));// 发送和接收信息“User”刚好相反
		newsMsg.setFromUserName((String)map.get("ToUserName"));
		newsMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
		newsMsg.setMsgType("news");// 文本类型消息
		newsMsg.setArticleCount(1);
		newsMsg.setItems(items);
		return  XMLUtil.convertToXml(newsMsg);	
	}
	public String onClickAdvice(Map map) {
		return null;
		
	}
	public String onClickSong(Map map) {
		MusicMsg musicMsg=new MusicMsg();
		musicMsg.setToUserName((String)map.get("FromUserName"));// 发送和接收信息“User”刚好相反
		musicMsg.setFromUserName((String)map.get("ToUserName"));
		musicMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
		musicMsg.setMsgType("music");
				
		Music music=session.load(Music.class, 1);
		System.out.println(music.getHQMusicUrl());
		session.getTransaction().commit();
		List<Music> musics=new ArrayList<Music>();
		//musics.add(music);
		musics.add(music);
		musicMsg.setMusics(musics);
		return XMLUtil.convertToXml(musicMsg);
		
	}
	@Override
	public String EvenReply(Map map) {
		String result;
		// TODO Auto-generated method stub
		//订阅事件
		if(map.get("Event").equals("subscribe")){
			//带参数二维码扫描事件
			if(map.get("Event").equals("xxxxxxx")){
				
			}else{
			TextMsg textMsg = new TextMsg();
            textMsg.setToUserName((String)map.get("FromUserName"));// 发送和接收信息“User”刚好相反
            textMsg.setFromUserName((String)map.get("ToUserName"));
            textMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
            textMsg.setMsgType("text");// 文本类型消息
            textMsg.setContent((new StringBuilder("欢迎关注好想嗮夕阳！！")).toString());
            result=XMLUtil.convertToXml(textMsg); 
            return result;
			}
			}
		//取消订阅事件
		else if(map.get("Event").equals("unsubscribe")){
			
		}
		return null;
	}
	public Music EveryDayOneSong(){
		JSONObject song=this.CreatSong();
		Music music=new Music();
		music.setTitle(song.getString("alias").toString());
		music.setMusicUrl(song.getString("mp3Url").toString());
		
		
		
		return null;
	}
	public JSONObject CreatSong(){
	
		Random rand = new Random();  
		int songID=(rand.nextInt(5040134)+59866);		
		String NeteaseCloudUrl="http://music.163.com/api/song/detail/?id="+songID+"&ids=["+songID+"]&csrf_token=";
		JSONObject json=HttpUrlDAO.HttpUrl(NeteaseCloudUrl);
		if(json.get("songs").toString()==null){
			
			  return this.CreatSong();
		}
		return json;
	}
}
