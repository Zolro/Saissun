package com.sais.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

























import com.sais.dao.GetMsgDAO;
import com.sais.dao.TestDAO;
import com.sais.dao.imp.GetMsgDAOImp;
import com.sais.msgpojo.ImageMsg;
import com.sais.msgpojo.TextMsg;
import com.sais.util.SignUtil;
import com.sais.util.XMLUtil;


/**
 * Servlet implementation class CrazyServlet
 */
public class CrazyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
       PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
       if (SignUtil.checkSignature(signature, timestamp, nonce)) {  
           out.print(echostr);  
        }  
        out.close();
        out = null;
        
       
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1.获取XML文件
		 * 2.解析XML文件
		 * 3.判断关键字，做出对应的反应
		 * 4。把类对象封装为XML,响应前台
		 * 5.放回信息
		 */
		// TODO Auto-generated method stub
		 // 设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("html/text;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        /*
         * 该部分我们获取用户发送的信息，并且解析成<K,V>的形式进行显示
         */
        // 解析用户发送过来的信息
        InputStream is = req.getInputStream();// 拿取请求流
        // 将解析结果存储在HashMap中
        Map map = new HashMap();
        // 解析xml，将获取到的返回结果xml进行解析成我们习惯的文字信息
        SAXReader reader = new SAXReader();// 第三方jar:dom4j【百度：saxreader解析xml】
        Document document = null;
        try {
            document = reader.read(is);
        } catch (DocumentException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 测试输出
        Set<String> keySet = map.keySet();

        /*
         * 该部分我们尝试按照文档的要求格式给用户回复文本信息、图文消息。重点：按照文档要求构造需要的参数。特别注意：参数区分大小写。
         */
     /*   GetMsgDAO gmd=new GetMsgDAOImp();
        gmd.msg(map);*/
        
        // //实例1：发送普通文本消息,请查看文档关于“回复文本消息”的xml格式
        //
        // // 第一步：按照回复文本信息构造需要的参数
      
      /*   TextMsg textMsg = new TextMsg();
         textMsg.setToUserName(map.get("FromUserName"));// 发送和接收信息“User”刚好相反
         textMsg.setFromUserName(map.get("ToUserName"));
         textMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
         textMsg.setMsgType("text");// 文本类型消息
         textMsg.setContent("获取之前的信息是:"+map.get("Content")+"||我是服务器回复给用户的信息,本微信名是"+map.get("ToUserName"));
         String textMsg2Xml = XMLUtil.convertToXml(textMsg); 
         PrintWriter printWriter = resp.getWriter();
         printWriter.print(textMsg2Xml);*/
        String type = (String)map.get("MsgType");
       /* String event=(String)map.get("Event");
        if(type.equals("event")&&event.equals("subscribe")){
        	
        		 TextMsg textMsg = new TextMsg();
                 textMsg.setToUserName(map.get("FromUserName"));// 发送和接收信息“User”刚好相反
                 textMsg.setFromUserName(map.get("ToUserName"));
                 textMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
                 textMsg.setMsgType("text");// 文本类型消息
                 textMsg.setContent((new StringBuilder("欢迎关注好想嗮夕阳！！")).toString());
                 String textMsg2Xml = XMLUtil.convertToXml(textMsg); 
                 PrintWriter printWriter = resp.getWriter();
                 printWriter.print(textMsg2Xml);
        	
        	
        	
        	
        }*/
     if(type.equals("text")){
            TextMsg textMsg = new TextMsg();
            textMsg.setToUserName((String)map.get("FromUserName"));
            textMsg.setFromUserName((String)map.get("ToUserName"));
            textMsg.setCreateTime((new Date()).getTime());
            textMsg.setMsgType("text");
            textMsg.setContent((new StringBuilder("获取之前的信息是:")).append((String)map.get("Content")).append("||我是服务器回复给用户的信息").toString());
            String textMsg2Xml = XMLUtil.convertToXml(textMsg);
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(textMsg2Xml);
            TestDAO test = new TestDAO();
            try {
				test.sendMsgToKF(textMsg.getToUserName(), textMsg.getMsgType(), textMsg.getContent());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
     if(type.equals("image")){     	 
            ImageMsg text = new ImageMsg();
            text.setToUserName((String)map.get("FromUserName"));
            text.setFromUserName((String)map.get("ToUserName"));
            text.setCreateTime((new Date()).getTime());
            text.setMsgType("image");
            String str[] = {
                (String)map.get("MediaId"), (String)map.get("MediaId")
            };
            text.setImage(str);
            String textMsg2Xml = XMLUtil.convertToXml(text);
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(textMsg2Xml);
            TestDAO test = new TestDAO();
            try {
				test.sendMsgToKF(text.getToUserName(), text.getMsgType(),(String)map.get("MediaId"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        //
        // // // 第二步，将构造的信息转化为微信识别的xml格式【百度：xstream bean转xml】
       
        // XStream  xStream = new XStream ();
         //xStream.alias("xml", textMsg.getClass());
        // String textMsg2Xml = xStream.toXML(textMsg);
        // System.out.println(textMsg2Xml);
        //
        // // // 第三步，发送xml的格式信息给微信服务器，服务器转发给用户
       

        // //实例2，发送图文消息。请查看文档关于“回复图文消息”的xml格式
      /*  if(type.equals("image")){
        // 第一步：按照回复图文信息构造需要的参数
        	ImageMsg text=new ImageMsg();
        	text.setToUserName(map.get("FromUserName"));// 发送和接收信息“User”刚好相反
        	text.setFromUserName(map.get("ToUserName"));
        	text.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
        	text.setMsgType("image");// 文本类型消息
        	String[] str={map.get("MediaId"),map.get("MediaId")};
        	text.setImage(str);
        	String textMsg2Xml = XMLUtil.convertToXml(text); 
            PrintWriter printWriter = resp.getWriter();
            printWriter.print(textMsg2Xml);
        }*/
        /*
         *    List<Article> articles = new ArrayList<Article>();
         Article a = new Article();
        a.setTitle("我是图片标题");
        a.setUrl("www.baidu.com");// 该地址是点击图片跳转后
        a.setPicUrl("http://b.hiphotos.baidu.com/image/pic/item/08f790529822720ea5d058ba7ccb0a46f21fab50.jpg");// 该地址是一个有效的图片地址
        a.setDescription("我是图片的描述");
        articles.add(a);
        PicAndTextMsg picAndTextMsg = new PicAndTextMsg();
        picAndTextMsg.setToUserName(map.get("FromUserName"));// 发送和接收信息“User”刚好相反
        picAndTextMsg.setFromUserName(map.get("ToUserName"));
        picAndTextMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
        picAndTextMsg.setMsgType("news");// 图文类型消息
        picAndTextMsg.setArticleCount(1);
        picAndTextMsg.setArticles(articles);
        // 第二步，将构造的信息转化为微信识别的xml格式【百度：xstream bean转xml】
        
     /*   XStream xStream = new XStream();
        xStream.alias("xml", picAndTextMsg.getClass());
        xStream.alias("item", a.getClass());
        String picAndTextMsg2Xml = xStream.toXML(picAndTextMsg);
        System.out.println(picAndTextMsg2Xml);
        // 第三步，发送xml的格式信息给微信服务器，服务器转发给用户
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(picAndTextMsg2Xml);
        String textMsg2Xml = XMLUtil.convertToXml(picAndTextMsg); 
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(textMsg2Xml); 
          */
	}

}
