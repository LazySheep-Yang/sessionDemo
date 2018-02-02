package com.lvyang.SessionDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLog
 * 
 * 从jsp登录，传入用户名和密码
 * 
 * 判断用户名是否正确，如正确将其封装到对象保存在session里面，在其它页面即可得到用户信息
 */
@WebServlet("/SessionLog")
public class SessionLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 response.setHeader("Content-type", "text/html;charset=utf-8");
	 response.setCharacterEncoding("utf-8");
	 
	 //获取到jsp发来的用户
	 String name=request.getParameter("username");
	 String pass=request.getParameter("password");
	 
	 List<User> list=Db.getList();
	 
	 
	 for(User U:list){
		 if(U.getUsername().equals(name)&&U.getPassword().equals(pass)){
			 //跳转到成功页面
			 
			 //在session存入用户，这样在其它页面就可以操作用户
			 /*
	通过getsession,获取到session，在获取到用户，根据用户获取它的购物记录等，也可以通过
	removeAttribute()移除用户
			  */
			 HttpSession session=request.getSession();
			 session.setAttribute("user", U);
			 response.sendRedirect("/SessionDemo/succ.jsp");
			 return;
		 }
	 }
	 
	 //没有登录成功
	 response.getWriter().write("登录失败");
		
	}

}
