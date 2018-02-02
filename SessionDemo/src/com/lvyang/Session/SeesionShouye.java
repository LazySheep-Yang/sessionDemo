package com.lvyang.Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeesionShouye
 */
@WebServlet("/SeesionShouye")
public class SeesionShouye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       /*
        * 如果浏览器禁用了cookie也就是发送cookie的时候浏览器不接收，那么就不能根据cookieID找到session，还是不能获取
购买的商品信息。访问服务器都是通过超链接访问，如果不以cookie形式发送ID号，那么可以通过点击超链接的时候让
超链接带ID号过来，也就是当用户访问首页的时候，为每个用户浏览器创建session会话，通过response的encodeURL()
方法在每个超链接的后面加上session的ID号，访问到超链接的服务器后，获取ID，找到session
        */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		request.getSession();
		 String url1=response.encodeURL("/SessionDemo/buy");
		 String url2=response.encodeURL("/SessionDemo/pay");
		 PrintWriter writer=response.getWriter();
		 writer.write("<a href="+url1+">购买</a><br>");
		 writer.write("<a href="+url2+">支付</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
