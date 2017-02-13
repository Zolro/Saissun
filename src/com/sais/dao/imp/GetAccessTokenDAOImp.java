package com.sais.dao.imp;

import com.sais.pojo.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.sais.pojo.*;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;





import com.sais.dao.GetAccessTokenDAO;

public class GetAccessTokenDAOImp implements GetAccessTokenDAO{

	private  SessionFactory sessionFactory;//会话工厂，用于创建会话
	private Session session;//hibernate会话
	private Transaction transaction; //hiberante事务
	private StandardServiceRegistry registry;
	
	public static final String APPID="wx49173e4a522176a1";
    public static final String APPSecret="9b97f5e1af86a293c0cebec60141473f";
    public static final String AccessUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSecret;
    public static final String AutoReplyUrl="https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=";
    public static final String SelectMenu="https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
    public static final String DeleteMenu="https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=";
    public static final String CreadMenu=" https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
    public static final String CreadAlityMenu="https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=";
    public static final String DeleteAlityMenu="https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=";
    public static final String MatchAlityMenu="https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=";
  
    public GetAccessTokenDAOImp() {
		super();
	}
	//获取access_token		
  	@Override
  	public  String getAccess() throws JSONException {
  		registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			AccessToken accesstk=(AccessToken) session.get(AccessToken.class, 1);
			 if(accesstk!=null){
				 long start=accesstk.getCreatDate().getTime();
		  		 long now=new Date().getTime();
		  		 System.out.println(now-start);
		  			if((now-start)<= (2*1000*3600)){
		  				System.out.println("测试");
		  				session.getTransaction().commit();
		  				session.close();  
		  				return accesstk.getCode();
		  			}else{	
		  			 session.delete(accesstk);
		  			 session.getTransaction().commit();
		  			session.beginTransaction();
					 JSONObject jsonat=HttpUrlDAO.HttpUrl(AccessUrl);
			  		 AccessToken access=new AccessToken();
			  		 access.setCode(jsonat.getString("access_token").toString());
			  		 access.setCreatDate(new Date());
			  		 session.save(access);
			  		 session.getTransaction().commit();
			  		 session.close();
			  		 return jsonat.getString("access_token").toString();	
		  			}
			 }
				 JSONObject at=HttpUrlDAO.HttpUrl(AccessUrl);
		  		 AccessToken access=new AccessToken();
		  		 access.setCode(at.getString("access_token").toString());
		  		 access.setCreatDate(new Date());
		  		 session.save(access);
		  		 session.getTransaction().commit();
		  		 session.close();
	  			 return at.getString("access_token").toString();
			 	
			 
  			}
  			
  	
	@Override
	public String CreatMenu(JSONObject json) throws JSONException,IOException {
		// TODO Auto-generated method stub
		String strurl=CreadMenu+getAccess();
		System.out.println(strurl);
		URL getUrl = new URL(strurl);
		HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
		http.setRequestMethod("POST");
		http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		http.setDoOutput(true);
		http.setDoInput(true);
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
		System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
		http.connect();
		OutputStream os= http.getOutputStream();
		os.write(json.toString().getBytes("UTF-8"));//传入参数
		os.flush();
		os.close();
		InputStream is =http.getInputStream();
		int size =is.available();
		byte[] jsonBytes =new byte[size];
		is.read(jsonBytes);
		String message=new String(jsonBytes,"UTF-8");
		System.out.println(message);
		return message;
	}
	@Override
	public String AutoReplyRules() throws JSONException {
		// TODO Auto-generated method stub
		String url=AutoReplyUrl+this.getAccess();
  			return HttpUrlDAO.HttpUrl(url).toString();
		
	}
	@Override
	public String SelectMenu() throws JSONException,
			IOException {
		// TODO Auto-generated method stub
				String strurl=SelectMenu+getAccess();
				System.out.println(strurl);
				URL getUrl = new URL(strurl);
				HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
				//http.setRequestMethod("POST");
				http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				http.setDoOutput(true);
				http.setDoInput(true);
				System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
				System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
				http.connect();
				//OutputStream os= http.getOutputStream();
				InputStream is =http.getInputStream();
				int size =is.available();
				byte[] jsonBytes =new byte[size];
				is.read(jsonBytes);
				String message=new String(jsonBytes,"UTF-8");
				System.out.println(message.toString());
				return message;
	}
	@Override
	public String DeleteMenu() throws JSONException, IOException {
		// TODO Auto-generated method stub
		String strurl=DeleteMenu+getAccess();
		System.out.println(strurl);
		URL getUrl = new URL(strurl);
		HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
		//http.setRequestMethod("POST");
		http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		http.setDoOutput(true);
		http.setDoInput(true);
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
		System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
		http.connect();
		//OutputStream os= http.getOutputStream();
		InputStream is =http.getInputStream();
		int size =is.available();
		byte[] jsonBytes =new byte[size];
		is.read(jsonBytes);
		String message=new String(jsonBytes,"UTF-8");
		System.out.println(message.toString());
		return message;
	}
	@Override
	public String CreatAlityMenu(String creat) throws JSONException,
			IOException {
		// TODO Auto-generated method stub
				String strurl=CreadAlityMenu+getAccess();
				System.out.println(strurl);
				URL getUrl = new URL(strurl);
				HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
				http.setRequestMethod("POST");
				http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
				http.setDoOutput(true);
				http.setDoInput(true);
				System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
				System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
				http.connect();
				OutputStream os= http.getOutputStream();
				os.write(creat.getBytes("UTF-8"));//传入参数
				os.flush();
				os.close();
				InputStream is =http.getInputStream();
				int size =is.available();
				byte[] jsonBytes =new byte[size];
				is.read(jsonBytes);
				String message=new String(jsonBytes,"UTF-8");
				System.out.println(message);
				return "Nice";
	}
	@Override
	public String DeleteAlityMenu(JSONObject json) throws JSONException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String MatchAlityMenu(JSONObject json) throws JSONException, IOException {
		String strurl=MatchAlityMenu+getAccess();
		System.out.println(strurl);
		URL getUrl = new URL(strurl);
		HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
		http.setRequestMethod("POST");
		http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		http.setDoOutput(true);
		http.setDoInput(true);
		System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
		System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
		http.connect();
		OutputStream os= http.getOutputStream();
		os.write(json.toString().getBytes("UTF-8"));//传入参数
		os.flush();
		os.close();
		InputStream is =http.getInputStream();
		int size =is.available();
		byte[] jsonBytes =new byte[size];
		is.read(jsonBytes);
		String message=new String(jsonBytes,"UTF-8");
		return message;
	}
	
}
