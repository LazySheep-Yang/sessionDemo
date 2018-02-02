package com.lvyang.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionPay
 */
@WebServlet("/SessionPay")
public class SessionPay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Content-type", "text/html;charset=utf-8");
		//获取Session,发现浏览器有session，直接获取,false代表值获取，不创建
		//false应用于查看商品，因为当某用户什么也没买，就查看商品的话，设false就不会创建session
		HttpSession session=request.getSession();
		response.getWriter().write(session.getAttribute("name").toString());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
