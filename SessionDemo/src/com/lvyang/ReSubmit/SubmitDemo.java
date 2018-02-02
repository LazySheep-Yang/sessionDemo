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
 * session����Ӧ��3��
 * �û���¼
 * �����ظ��ύ
 * ���ͼƬ����֤��
 * ��drawtext��ʱ�򣬽����ִ���session�������ύ�������֤����ʱ����session�ıȽϣ������һ�ŵ�ʱ��
 * ����·���ٴ����������������������session��setAttribute(),Ҳ��ı䡣ƥ���ʱ��ע��jsp��servlet����
 * �ı����Ƿ�һ��
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
		//System.out.println("���Ѿ�ע��");
		
		
		
		//�����Ƿ��ύ�ı��
		boolean flag=isFormed(request);
		//���Ϊtrue������û���ύ
		if(flag){
			
			
			//��session��id��ɾ��,�Ȳ�������ֹ�����ӳ�
			request.getSession().removeAttribute("id");
			
			//������Ի�ȡ�û�����Ϣ�����������ݿ�
			System.out.println("ע��ɹ�");
		}
		
		//Ϊ�٣������Ѿ�ע��
		System.out.println("���Ѿ�ע��");
		return;
	}


	private boolean isFormed(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String idSession=(String) request.getSession().getAttribute("id");
		String idform=request.getParameter("hidden");
		
		//��ʾ�������Ѿ�ɾ��id���ظ��ύ
		if(idSession==null){
			return false;
		}
		
		
		//��ʾ�û�û��ͨ��servlet����jsp��û�в���id,���ύ
		if(idform==null){
			
			return false;
		}
		
		//������id�������idһ�����ύ
		if(idSession==idform){
			
			return true;
		}
		
		return false;
	}

}
