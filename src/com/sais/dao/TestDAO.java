package com.sais.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class TestDAO {
	/**
	 * 微信公众号获取access_token url
	 */
	private String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7b5f5d842d664832&secret=189bd35aba932b1f48fe432c21b711a7";
	/**
	 * 微信企业号corpID
	 */
	private String corpID = "wx42c8b8a420e016b4";
	/**
	 * 微信企业号企业客服获取access_token url
	 */
	private String access_token_url_qy = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpID+"&corpsecret=lAevzVxFURpGbTGwy2KrWAhRF0plSOFjsPH5bWPzMtPrgeb7qnF4vVa92O0h8jV_";

	/**
	 * 获取微信企业号或公众号access_token URL:
	 * @throws JSONException
	 */
	public String getAccessToken(String url) throws Exception {
		String accessToken = "";
		JSONObject result = null;
		try {
			result = httpRequestGet(url);
			// System.out.println("result:"+result);
			accessToken = result.getString("access_token");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("获取 AccessToken 失败!");
			System.err.println("errcode:" + result.get("errcode"));
			System.err.println("errmsg:" + result.get("errmsg"));
		}
		return accessToken;
	}
	
	/**
	 * 发送消息到指定客服
	 * https://qyapi.weixin.qq.com/cgi-bin/kf/send?access_token=ACCESS_TOKEN
	 * 
	 * @throws Exception
	 */
	public void sendMsgToKF(String sender_userid, String msgtype, String content) throws Exception {
		String accessToken = getAccessToken(access_token_url_qy);
		String url = "https://qyapi.weixin.qq.com/cgi-bin/kf/send";
		url += "?access_token=" + accessToken;
		String chose = msgtype.equals("text") ? "content" : "media_id";
		String msg = "{\"sender\": {\"type\": \"openid\",\"id\": \"" + sender_userid + "\"},"
				+ "\"receiver\": {\"type\": \"kf\", \"id\": \"pty\"}," + "\"msgtype\": \"" + msgtype + "\",\"" + msgtype
				+ "\": { \"" + chose + "\":\"" + content + "\"}}";
		httpRequestPostJSON(url, msg);
	}
	
	public static void httpRequestPostJSON(String post_url, String json) throws JSONException {
		try {
			JSONObject obj = new JSONObject(json);
			System.out.println(obj);
			// 创建url资源
			URL url = new URL(post_url);
			// 建立http连接
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 设置允许输出
			conn.setDoOutput(true);
			conn.setDoInput(true);

			// 设置不用缓存
			conn.setUseCaches(false);
			// 设置传递方式
			conn.setRequestMethod("POST");
			// 设置维持长连接
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 设置文件字符集:
			conn.setRequestProperty("Charset", "UTF-8");
			// 转换为字节数组
			byte[] data = (obj.toString()).getBytes();
			// 设置文件长度
			conn.setRequestProperty("Content-Length", String.valueOf(data.length));
			// 设置文件类型:
			conn.setRequestProperty("contentType", "application/json");
			// 开始连接请求
			conn.connect();
			OutputStream out = conn.getOutputStream();
			// 写入请求的字符串
			out.write((obj.toString()).getBytes());
			out.flush();
			out.close();
			System.out.println(conn.getResponseCode());

			// 请求返回的状态
			if (conn.getResponseCode() == 200) {
				System.out.println("连接成功");
				// 请求返回的数据
				InputStream in = conn.getInputStream();
				String a = null;
				try {
					byte[] data1 = new byte[in.available()];
					in.read(data1);
					// 转成字符串
					a = new String(data1);
					System.out.println(a);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				System.out.println("no++");
			}

		} catch (Exception e) {

		}
	}
	
	/**
	 * http get 请求
	 * 
	 * @param urlStr
	 *            请求URL地址
	 * @throws Exception
	 */
	public static JSONObject httpRequestGet(String urlStr) throws Exception {
		// URL拼接,如："http://www.baidu.com?name=HI,中国",这里对特殊字符进行了编码，不然会产生乱码
		// URL url = new URL(urlStr + "?filePath=" +
		// URLEncoder.encode("设计资料/设计", "utf-8"));
		URL url = new URL(urlStr);

		// openConnection函数会根据URL的协议返回不同的URLConnection子类的对象
		// 这里URL是一个http,因此实际返回的是HttpURLConnection
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		// 进行连接,实际上request要在下一句的connection.getInputStream()函数中才会真正发到 服务器****待验证
		httpConn.connect();

		// 取得输入流，并使用Reader读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

		System.out.println("=========get request接收数据内容开始============");
		String lines;
		String result = "";
		while ((lines = reader.readLine()) != null) {
			System.out.println(lines);
			result += lines;
		}
		reader.close();
		System.out.println("=========get request接收数据内容结束============");
		httpConn.disconnect();
		JSONObject obj = new JSONObject(result);
		return obj;
	}
}
