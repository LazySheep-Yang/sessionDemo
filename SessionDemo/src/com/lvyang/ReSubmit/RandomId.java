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
 *���servletĿ���Ǹ�form������һ������ı��
 */
@WebServlet("/RandomId")
public class RandomId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ��id
		TokenProcessor tokenProcessor=TokenProcessor.getInstance();
		String id=tokenProcessor.generalToken();
		
		/*
		��id����session����Ϊ�Ժ�form��Ҫ�ύ��֤id��������request���´�form�ύ��ʱ���ύ������servlet
		��һ��ȫ�µ�request���ڴ���servletͨ��request.getAttribute("id")

		 */
		request.getSession().setAttribute("id", id);
		
		//ת������ҳ�棬������id
		request.getRequestDispatcher("/submit.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
