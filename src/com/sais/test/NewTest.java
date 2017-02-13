package com.sais.test;

import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.sais.dao.imp.GetAccessTokenDAOImp;
import com.sais.dao.imp.HttpUrlDAO;
import com.sais.dao.imp.WxUserDAOImp;
import com.sais.pojo.WeChatUser;

public class NewTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	/*	News n=new News();
		n.setDescription("newsDES");
		n.setPicUrl("newspicurl");
		n.setTitle("赵云");
		n.setUrl("NEWSURL");*/
		
		/*News nn=new News();
		nn.setDescription("newsDES2");
		nn.setPicUrl("newspicurl222");
		nn.setTitle("马超");
		nn.setUrl("NEWSURL22");*/
		
		
		
	
		// list.add(n);
		/*
		 * list.add(nn); System.out.println(list.size());
		 * System.out.println(list.get(0).toString());
		 */
		// System.out.println(list.get(1).toString());
		/*
		 * MusicMsg musicMsg=new MusicMsg();
		 * musicMsg.setToUserName("this is user openID");// 发送和接收信息“User”刚好相反
		 * musicMsg.setFromUserName("this is my wxnum");
		 * musicMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
		 * musicMsg.setMsgType("music"); Music music=new Music();
		 * music.setTitle("湫兮如风 "); music.setDescription(
		 * "动画电影《大鱼海棠》片尾曲《湫兮如风》，由徐佳莹演唱，吉田潔作曲，梁旋填词。“湫兮如风”一词出自宋玉《高唐赋》，原文“湫兮如风，凄兮如雨”描绘“凉风习习,细雨清凄”的景象。而在此歌曲中，暗指电影主人公之一“湫”的命运。"
		 * ); music.setMusicUrl(
		 * "http://music.163.com/outchain/player?type=1&id=34768922&auto=0&height=90"
		 * ); List<Music> musics=new ArrayList<Music>(); musics.add(music);
		 * musicMsg.setMusics(musics);
		 */
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		SessionFactory sessionFactory = new MetadataSources(registry)
				.buildMetadata().buildSessionFactory();
		Session session = sessionFactory.openSession();
		/*session.beginTransaction();
		String hql="from Music where title=:mtitle";
		Query q = session.createQuery(hql);
		q.setString("mtitle","湫兮如风");
		Music m=(Music) q.uniqueResult();
		System.out.println(m.getMusicUrl());*/
		/*Music music=new Music();
		music.setTitle("湫兮如风 ");
		music.setDescription("动画电影《大鱼海棠》片尾曲《湫兮如风》，由徐佳莹演唱，吉田潔作曲，梁旋填词。“湫兮如风”一词出自宋玉《高唐赋》，原文“湫兮如风，凄兮如雨”描绘“凉风习习,细雨清凄”的景象。而在此歌曲中，暗指电影主人公之一“湫”的命运。");
		music.setMusicUrl("http://music.163.com/outchain/player?type=1&id=34768922&auto=0&height=90");
		session.save(music);*/
		GetAccessTokenDAOImp access = new GetAccessTokenDAOImp();
		String OpenId = "oIDN8wEE8xwKNSM6PjVLaZ66Lo0s";
		String url = WxUserDAOImp.WxUrl + "access_token=" + access.getAccess()
				+ "&openid=" + OpenId + "&lang=zh_CN";
		/* JSONObject obj=new JSONObject().fromObject(HttpUrlDAO.HttpUrl(url)); */
		// JSONObject obj = new
		// JSONObject().fromObject(HttpUrlDAO.HttpUrl(url));
		JSONObject json = HttpUrlDAO.HttpUrl(url);
		WeChatUser user = (WeChatUser) JSONObject
				.toBean(json, WeChatUser.class);
		System.out.println(user.getNickname()
				+ "-----------------------------------");
		session.save(user);
		session.getTransaction().commit();
		session.close();	
	}

}
