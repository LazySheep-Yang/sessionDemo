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
 * ��jsp��¼�������û���������
 * 
 * �ж��û����Ƿ���ȷ������ȷ�����װ�����󱣴���session���棬������ҳ�漴�ɵõ��û���Ϣ
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
	 
	 //��ȡ��jsp�������û�
	 String name=request.getParameter("username");
	 String pass=request.getParameter("password");
	 
	 List<User> list=Db.getList();
	 
	 
	 for(User U:list){
		 if(U.getUsername().equals(name)&&U.getPassword().equals(pass)){
			 //��ת���ɹ�ҳ��
			 
			 //��session�����û�������������ҳ��Ϳ��Բ����û�
			 /*
	ͨ��getsession,��ȡ��session���ڻ�ȡ���û��������û���ȡ���Ĺ����¼�ȣ�Ҳ����ͨ��
	removeAttribute()�Ƴ��û�
			  */
			 HttpSession session=request.getSession();
			 session.setAttribute("user", U);
			 response.sendRedirect("/SessionDemo/succ.jsp");
			 return;
		 }
	 }
	 
	 //û�е�¼�ɹ�
	 response.getWriter().write("��¼ʧ��");
		
	}

}
