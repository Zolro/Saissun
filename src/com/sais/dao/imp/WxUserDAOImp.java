package com.sais.dao.imp;






import java.net.MalformedURLException;
import java.util.Map;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sais.dao.GetAccessTokenDAO;
import com.sais.dao.WxUserDAO;
import com.sais.pojo.WeChatUser;


public class WxUserDAOImp implements WxUserDAO {
	public static final String WxUrl="https://api.weixin.qq.com/cgi-bin/user/info?";
	public static final String WxUrlCreateTag="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=";
	public static final String WxUrlSelectTag="https://api.weixin.qq.com/cgi-bin/tags/get?access_token=";
	private GetAccessTokenDAO access;
	private  SessionFactory sessionFactory;//会话工厂，用于创建会话
	private Session session;//hibernate会话
	private Transaction transaction; //hiberante事务
	private StandardServiceRegistry registry;
	//private Configuration cfg;
	public WxUserDAOImp() {
		super();
		registry = new StandardServiceRegistryBuilder()
		.configure() // configures settings from hibernate.cfg.xml
		.build();
		//cfg=new Configuration().configure();
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();		
		access=new GetAccessTokenDAOImp();
	}

	@Override
	public String insertWxUser(String OpenId) {
		// TODO Auto-generated method stub
		String url=WxUrl+"access_token="+access.getAccess()+"&openid="+OpenId+"&lang=zh_CN";
		/* JSONObject obj=new JSONObject().fromObject(HttpUrlDAO.HttpUrl(url));*/
		//JSONObject obj = new JSONObject().fromObject(HttpUrlDAO.HttpUrl(url));
		JSONObject json=HttpUrlDAO.HttpUrl(url);
		System.out.println(json.toString());
		WeChatUser user=(WeChatUser)JSONObject.toBean(json,WeChatUser.class);
		System.out.println(user.getTagid_list()+"-----------------------------------");
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return "nice";

	}

	@Override
	public void DeleteWxUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void SelectWxUserByOpenID(String OpenID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateWxUserByID(String ID) {
		// TODO Auto-generated method stub

	}

	@Override
	public JSONObject CreateWxUserTag(JSONObject json) throws JSONException, MalformedURLException {
		// TODO Auto-generated method stub
		String url=WxUrlCreateTag+access.getAccess();
		JSONObject  tag=HttpUrlDAO.HttpUrl(url,json);
		return tag;
	}

	@Override
	public JSONObject SelectAccountTag(){
		// TODO Auto-generated method stub
		String url=WxUrlSelectTag+access.getAccess();
		JSONObject  tag=HttpUrlDAO.HttpUrl(url);
		return tag;
	}

	@Override
	public JSONObject UpdateWxUserTag(JSONObject tagMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject DeleteWxUserTag(JSONObject tagidlist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject FindWxUserByTag(JSONObject tagid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject CreateWxUserTagForMore(JSONObject OpenIDListAndTagID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject DeleteWxUserTagForMore(JSONObject OpenIDListAndTagID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject GetWxUserTagList(JSONObject OpenID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SelectWxUserListByOpenID(JSONObject OpenIDListMayAddLanguage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JSONObject SelectWxUserAtAccount(String OpenID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject CreateWxUserNoteName(JSONObject OpenidandNoteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String CreateWxUserLocation(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

}
