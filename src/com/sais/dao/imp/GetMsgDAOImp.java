package com.sais.dao.imp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.sais.dao.GetMsgDAO;
import com.sais.dao.TypeOfReplyDAO;
import com.sais.msgpojo.TextMsg;
import com.sais.util.XMLUtil;

public class GetMsgDAOImp implements GetMsgDAO {
	private TypeOfReplyDAO reply;
			
	public GetMsgDAOImp() {
		super();
		reply=new TypeOfReplyDAOImp();
	}

	@Override
	public String msg(Map map) {
		String type=(String) map.get("MsgType");
		 String textMsg2Xml;
		if(type.equals("event")){
			if(map.get("Event").equals("CLICK")){
				return	textMsg2Xml=reply.onClick(map,(String)map.get("EventKey"));				
			}else{
				return textMsg2Xml=reply.EvenReply(map);
				
			}
		}
		if(type.equals("text")){
			TextMsg textMsg = new TextMsg();
            textMsg.setToUserName((String)map.get("FromUserName"));// 发送和接收信息“User”刚好相反
            textMsg.setFromUserName((String)map.get("ToUserName"));
            textMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
            textMsg.setMsgType("text");// 文本类型消息
            //textMsg.setContent((new StringBuilder("接收到了文字信息")).toString());
          /*  StringBuffer buffer = new StringBuffer();

            buffer.append("您好,我是小q,请回复数字选择服务:").append("\n\n");

            buffer.append("1 天气预报").append("\n");

            buffer.append("2 公交查询").append("\n");

            buffer.append("3 周边搜索").append("\n");

            buffer.append("4 歌曲点播").append("\n");

            buffer.append("5 经典游戏").append("\n");

            buffer.append("6 美女电台").append("\n");

            buffer.append("7 人脸识别").append("\n");

            buffer.append("8 聊天唠嗑").append("\n\n");

            buffer.append("回复?显示此帮助菜单");*/  
            textMsg.setContent(map.get("Content").toString());
            textMsg2Xml=XMLUtil.convertToXml(textMsg); 
            return textMsg2Xml;
		}
        return ifError(map);
		// TODO Auto-generated method stub	 
	}

	
	
	
	



	@Override
	public String ifError(Map map) {
		// TODO Auto-generated method stub
		String textMsg2Xml;
		TextMsg textMsg = new TextMsg();
        textMsg.setToUserName((String)map.get("FromUserName"));// 发送和接收信息“User”刚好相反
        textMsg.setFromUserName((String)map.get("ToUserName"));
        textMsg.setCreateTime(new Date().getTime());// 消息创建时间 （整型）
        textMsg.setMsgType("text");// 文本类型消息
        textMsg.setContent((new StringBuilder("这项功能还在开发中，请期待！")).toString());
        textMsg2Xml=XMLUtil.convertToXml(textMsg); 
		return textMsg2Xml;
	}









	
	
}
