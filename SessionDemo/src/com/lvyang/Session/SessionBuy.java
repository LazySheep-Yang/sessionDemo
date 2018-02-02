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
 * Session记住：如果要长久保存会话或者多个浏览器共享数据，要重写cookie
 * 如果浏览器禁用cookie：那么只能通过url传入id的方式
 * 商务网站做购物都用cookie，因为cookie存入浏览器，session存在服务器，数据多造成压力大
 * 
 * Servlet implementation class SessionBuy
 * Session:会话，只有当服务器调用了request.getSeesion()后，才产生session对象
 * 一个浏览器只有一个session，新开浏览器后重新创建
 * 
 * session保存在服务器里面，默认只有30分钟有效期
 * 
 * 和cookie的区别：cookie是把用户的数据写给浏览器
 * session是把用户的数据写到用户独占的session中
 */
@WebServlet("/SessionBuy")
public class SessionBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//点击超链接进来；创建session，为这个浏览器创建
		HttpSession session=request.getSession();
		session.setAttribute("name", "洗衣机");
		/*String ID=session.getId();
		//覆盖默认的cookie
		Cookie cookie=new Cookie("JSESSIONID", ID);
		cookie.setMaxAge(0);
		cookie.setPath("/SessionDemo/");
		session.setAttribute("name", "洗衣机");
		response.addCookie(cookie);*/
		
		/*
		 当服务器有多个session时，浏览器如何取出对应的session呢？
		 其实session对象里面有一个id，这个id是以cookie的形式存入，并且这个cookie没有有效期，
		 也就是浏览器关闭了cookie消失，当再次打开浏览器访问的时候，cookie已经没有，id也没有，服务器认为
		 你没带session
		 所以服务器只能为你在创建session，所以显示不出信息
		 
		 解决办法：
		 自定义一个cookie，设置有效期，并且要与服务器默认的cookie的配置一样，便能覆盖
		 */
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
