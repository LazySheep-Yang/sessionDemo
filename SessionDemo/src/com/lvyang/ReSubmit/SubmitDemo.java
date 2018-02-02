package com.lvyang.ReSubmit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubmitDemo
 * 
 * session常见应用3：
 * 用户登录
 * 防表单重复提交
 * 随机图片的验证：
 * 在drawtext的时候，将文字存入session。。表单提交输入的验证符的时候与session的比较，点击换一张的时候
 * 由于路径再次向服务器发出了请求，所以session的setAttribute(),也会改变。匹配的时候注意jsp和servlet汉字
 * 的编码是否一样
 */
@WebServlet("/SubmitDemo")
public class SubmitDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("你已经注册");
		
		
		
		//返回是否提交的标记
		boolean flag=isFormed(request);
		//如果为true，代表没有提交
		if(flag){
			
			
			//将session的id号删除,先操作，防止网络延迟
			request.getSession().removeAttribute("id");
			
			//这里可以获取用户的信息，保存在数据库
			System.out.println("注册成功");
		}
		
		//为假，代表已经注册
		System.out.println("你已经注册");
		return;
	}


	private boolean isFormed(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String idSession=(String) request.getSession().getAttribute("id");
		String idform=request.getParameter("hidden");
		
		//表示服务器已经删除id，重复提交
		if(idSession==null){
			return false;
		}
		
		
		//表示用户没有通过servlet访问jsp，没有产生id,不提交
		if(idform==null){
			
			return false;
		}
		
		//带来的id与服务器id一样，提交
		if(idSession==idform){
			
			return true;
		}
		
		return false;
	}

}
