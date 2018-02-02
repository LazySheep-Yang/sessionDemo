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
        * ��������������cookieҲ���Ƿ���cookie��ʱ������������գ���ô�Ͳ��ܸ���cookieID�ҵ�session�����ǲ��ܻ�ȡ
�������Ʒ��Ϣ�����ʷ���������ͨ�������ӷ��ʣ��������cookie��ʽ����ID�ţ���ô����ͨ����������ӵ�ʱ����
�����Ӵ�ID�Ź�����Ҳ���ǵ��û�������ҳ��ʱ��Ϊÿ���û����������session�Ự��ͨ��response��encodeURL()
������ÿ�������ӵĺ������session��ID�ţ����ʵ������ӵķ������󣬻�ȡID���ҵ�session
        */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=utf-8");
		request.getSession();
		 String url1=response.encodeURL("/SessionDemo/buy");
		 String url2=response.encodeURL("/SessionDemo/pay");
		 PrintWriter writer=response.getWriter();
		 writer.write("<a href="+url1+">����</a><br>");
		 writer.write("<a href="+url2+">֧��</a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
