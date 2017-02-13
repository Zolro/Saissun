package com.sais.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import com.sais.dao.imp.GetMsgDAOImp;
import com.sais.util.SignUtil;

/**
 * Servlet implementation class WechatServlet
 */
public class WechatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WechatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		// TODO Auto-generated method stub
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 // 设置编码
//-------------------------------------下面解析部分----------------------------------------------------------------		
		System.out.println("开始解析收的的信息");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("html/text;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        //  该部分我们获取用户发送的信息，并且解析成<K,V>的形式进行显示
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
        for (Element e : elementList){
            map.put(e.getName(), e.getText());
            System.out.println(e.getName()+"__"+e.getText());
        }
        // 测试输出
        Set<String> keySet = map.keySet();
        // * 该部分我们尝试按照文档的要求格式给用户回复文本信息、图文消息。重点：按照文档要求构造需要的参数。特别注意：参数区分大小写。
//-------------------------------------上面是解析部分----------------------------------------------------------------	     
    	GetMsgDAO gmd=new GetMsgDAOImp();
        String msg=gmd.msg(map);
        PrintWriter printWriter = resp.getWriter();
        printWriter.print(msg);

	}
	
}
