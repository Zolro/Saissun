package com.sais.test;


import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sais.dao.imp.HttpUrlDAO;
import com.sais.msgpojo.ImageMsg;
import com.sais.msgpojo.Music;
import com.sais.msgpojo.MusicMsg;
import com.sais.msgpojo.News;
import com.sais.msgpojo.NewsMsg;
import com.sais.msgpojo.TextMsg;
import com.sais.msgpojo.Video;
import com.sais.msgpojo.VideoMsg;
import com.sais.msgpojo.VoiceMsg;
import com.sais.util.JsonUtil;
import com.sais.util.XMLUtil;




public class UtilTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ImageMsg text=new ImageMsg();
		//MusicMsg text=new MusicMsg();
		//NewsMsg text=new NewsMsg();
		//VideoMsg text=new VideoMsg();
		//VoiceMsg text=new VoiceMsg();
		//公有部分设值
	    /*text.setToUserName("刘备");
		text.setFromUserName("曹操");
		text.setCreateTime(125632);
		text.setMsgType("text");*/
	    //text
	    //text.setContent("Text输出");
		//image	
		/*String[] img={"图片地址1","图片地址1"};
		text.setImage(img);*/
		//music
		/*Music m=new Music();
		m.setDescription("muscides");
		m.setHQMusicUrl("musicHQM");
		m.setMusicUrl("musicurl");
		m.setThumbMediaId("musicthum");
		m.setTitle("musictitle");
		
		Music m1=new Music();
		m1.setDescription("muscides1");
		m1.setHQMusicUrl("musicHQM1");
		m1.setMusicUrl("musicurl1");
		m1.setThumbMediaId("musicthum1");
		m1.setTitle("musictitl1e1");
		
		text.add(m);
		text.add(m1);*/
	/*	News n=new News();
		n.setDescription("news_des1");
		n.setPicUrl("news_picurl");
		n.setTitle("news_title");
		n.setUrl("news_url");
		
		News n2=new News();
		n2.setDescription("news_des12");
		n2.setPicUrl("news_picurl2");
		n2.setTitle("news_title2");
		n2.setUrl("news_url2");
		 
        text.add(n);
        text.add(n2);*/
		String NeteaseCloudUrl="http://music.163.com/api/song/detail/?id=404783205&ids=[404783205]&csrf_token=";
		JSONObject json=HttpUrlDAO.HttpUrl(NeteaseCloudUrl);
		JSONArray songs=(JSONArray) json.get("songs");
		JSONObject jsonObject = null;
		JSONObject jsonArtists = null;
		
		for(int i = 0; i < songs.size(); i++){     
		 jsonObject = songs.getJSONObject(i);
		} 
		
		JSONArray artists=(JSONArray) jsonObject.get("artists");
		for(int i = 0; i < artists.size(); i++){     
			jsonArtists = artists.getJSONObject(i);
			} 
		JSONObject album=(JSONObject) jsonObject.get("album");
		JSONArray alias=(JSONArray) album.get("alias");
		System.out.println("--------------------------------------------------------------");
		System.out.println("歌名"+jsonObject.get("name"));
		System.out.println("歌手"+jsonArtists.get("name"));
		if(alias!=null)
		System.out.println(alias.get(0));
		System.out.println("链接"+jsonObject.get("mp3Url"));

		
		/*{
		    "songs": [
		        {
		     
		            "mp3Url": "http://m2.music.126.net/-LVKs0aQcJGASpMbk-Yb-w==/3420580706452426.mp3", 
		            "artists": [
		                {
		                    "img1v1Id": 0, 
		                    "alias": [ ], 
		                    "albumSize": 0, 
		                    "img1v1Url": "http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg", 
		                    "musicSize": 0, 
		                    "picId": 0, 
		                    "trans": "", 
		                    "picUrl": "http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg", 
		                    "briefDesc": "", 
		                    "name": "徐佳莹", 
		                    "id": 9940
		                }
		            ], 
		            "alias": [
		                "电影《大鱼海棠》片尾曲"
		            ], 		       		         		         		        
		            "album": {		               
		                "artists": [
		                    {
		                        "img1v1Id": 0, 
		                        "alias": [ ], 
		                        "albumSize": 0, 
		                        "img1v1Url": "http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg", 
		                        "musicSize": 0, 
		                        "picId": 0, 
		                        "trans": "", 
		                        "picUrl": "http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg", 
		                        "briefDesc": "", 
		                        "name": "徐佳莹", 
		                        "id": 9940
		                    }
		                ]		                          		                  
		            }, 
		            "name": "湫兮如风", 
		            "id": 420513838
		        }
		    ]
		}*/
	     
	   
	       
	       
      
	}

}
