package com.sais.dao;

import java.util.Map;
//创建模板 回复消息
public interface TypeOfReplyDAO {
	public String TextReply(Map map,String txt);
	public String LinkReply(Map map,String keyword);
	public String onClick(Map map,String clickword);
	public String EvenReply(Map map);
	//public String 
}
