package com.sais.dao.imp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;












import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.sais.pojo.WeChatUser;

public class HttpUrlDAO implements Serializable{
	public static JSONObject HttpUrl(String url) throws JSONException{
		// TODO Auto-generated method stub
  		/*
  		 * 分为二类,GET与POST请求。二者的区别在于：
  		 * a:) get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet
  		 *  b:) post与get的不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。 
  		 * */
		StringBuffer stringBuffer = new StringBuffer("");	
		try {
			
  			URL getUrl = new URL(url);
  			/*
  			 * 此处的urlConnection对象实际上是根据URL的 请求协议(此处是http)生成的URLConnection类 的子类HttpURLConnection,
  			 * 故此处最好将其转化为HttpURLConnection类型的对象,以便用到HttpURLConnection更多的API
  			 * */
  			HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
  			//设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在  http正文内，因此需要设为true, 默认情况下是false;  
  			//connection.setDoOutput(true);
  			// 设置是否从httpUrlConnection读入，默认情况下是true;  
  			connection.setDoInput(true);
  			// 设定请求的方法为"POST"，默认是GET  
  			//connection.setRequestMethod("Get");
  			// Post 请求不能使用缓存  
  			// 设定传送的内容类型是可序列化的java对象   
 			// (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)  
  			connection.setUseCaches(true);
  			connection.setInstanceFollowRedirects(true);
  			
  			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
  			String line;
  			while ((line = reader.readLine()) != null) {
  			stringBuffer.append(line);
  			}
  			reader.close();
  			} catch (Exception e) {
  			e.printStackTrace();
  			}
  			JSONObject json;
  			json=new JSONObject().fromObject(stringBuffer.toString());
  			
  			//String str=json.getString("access_token").toString();
  			System.out.println(json.toString());
  			return json;
		
	}
	public static JSONObject HttpUrl(String url,JSONObject json) throws JSONException, MalformedURLException{
		StringBuffer stringBuffer = new StringBuffer("");	
		String message=null;
		try {
			URL getUrl = new URL(url);
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
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
  			String line;
  			while ((line = reader.readLine()) != null) {
  			stringBuffer.append(line);
  			}
  			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 JSONObject json1=new JSONObject().fromObject(stringBuffer.toString());
		return json1;
		
		
	}

}
