package com.sais.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DBHelper {
	 public static final String url = "jdbc:mysql://localhost:3306/cmbc?useUnicode=true&characterEncoding=UTF8";  
	    public static final String name = "com.mysql.jdbc.Driver";  
	    public static final String user = "root";  
	    public static final String password = "root";  
	  
	    public Connection conn = null;  
	    public PreparedStatement pst = null;  
	    public DBHelper(String sql) {  
	        try {  
	            Class.forName(name);//指定连接类型  
	            conn = (Connection) DriverManager.getConnection(url, user, password);//获取连接  
	           
	            //pst = (PreparedStatement) conn.prepareStatement(sql);//准备执行语句  
	            
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	    }  
	  
	    public void close() {  
	        try {  
	            this.conn.close();  
	            this.pst.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
}
