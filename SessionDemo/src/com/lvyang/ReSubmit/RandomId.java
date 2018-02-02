package com.lvyang.ReSubmit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 * Servlet implementation class RandomId
 *这个servlet目的是给form表单产生一个随机的编号
 */
@WebServlet("/RandomId")
public class RandomId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取到id
		TokenProcessor tokenProcessor=TokenProcessor.getInstance();
		String id=tokenProcessor.generalToken();
		
		/*
		将id存入session域，因为以后form还要提交验证id，若存入request，下次form提交的时候，提交到处理servlet
		是一个全新的request，在处理servlet通过request.getAttribute("id")

		 */
		request.getSession().setAttribute("id", id);
		
		//转发到表单页面，并传入id
		request.getRequestDispatcher("/submit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
