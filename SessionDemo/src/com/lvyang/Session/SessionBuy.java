package com.lvyang.Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Session��ס�����Ҫ���ñ���Ự���߶��������������ݣ�Ҫ��дcookie
 * ������������cookie����ôֻ��ͨ��url����id�ķ�ʽ
 * ������վ�����ﶼ��cookie����Ϊcookie�����������session���ڷ����������ݶ����ѹ����
 * 
 * Servlet implementation class SessionBuy
 * Session:�Ự��ֻ�е�������������request.getSeesion()�󣬲Ų���session����
 * һ�������ֻ��һ��session���¿�����������´���
 * 
 * session�����ڷ��������棬Ĭ��ֻ��30������Ч��
 * 
 * ��cookie������cookie�ǰ��û�������д�������
 * session�ǰ��û�������д���û���ռ��session��
 */
@WebServlet("/SessionBuy")
public class SessionBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��������ӽ���������session��Ϊ������������
		HttpSession session=request.getSession();
		session.setAttribute("name", "ϴ�»�");
		/*String ID=session.getId();
		//����Ĭ�ϵ�cookie
		Cookie cookie=new Cookie("JSESSIONID", ID);
		cookie.setMaxAge(0);
		cookie.setPath("/SessionDemo/");
		session.setAttribute("name", "ϴ�»�");
		response.addCookie(cookie);*/
		
		/*
		 ���������ж��sessionʱ����������ȡ����Ӧ��session�أ�
		 ��ʵsession����������һ��id�����id����cookie����ʽ���룬�������cookieû����Ч�ڣ�
		 Ҳ����������ر���cookie��ʧ�����ٴδ���������ʵ�ʱ��cookie�Ѿ�û�У�idҲû�У���������Ϊ
		 ��û��session
		 ���Է�����ֻ��Ϊ���ڴ���session��������ʾ������Ϣ
		 
		 ����취��
		 �Զ���һ��cookie��������Ч�ڣ�����Ҫ�������Ĭ�ϵ�cookie������һ�������ܸ���
		 */
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
