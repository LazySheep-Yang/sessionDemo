package com.lvyang.ReSubmit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

//���������������ͬ���ʵĿ��ǣ�������д�ɵ���ģʽ��ʹһ������������ͬ����������ʽ���
public class TokenProcessor {//����

	private static final TokenProcessor r=new TokenProcessor();
	private TokenProcessor(){
		
	}
	public static TokenProcessor getInstance() {
			return r;
	}
	
	
	//����������ַ���
	public String generalToken() {
		//���ݵ�ǰʱ���һ�����������ʽ
		String token=System.currentTimeMillis()+new Random().nextInt()+"";
		
		/*�õ�����ժҪ��ÿ�����ݶ���һ��ָ�ƣ�ժҪ��������һ��
		 * �����õ���������ַ����ȿ��ܲ�һ����ʹ��MessageDigest��
		 * ����ΪӦ�ó����ṩ��ϢժҪ�㷨�Ĺ��ܣ��� MD5 �� SHA �㷨��
		 * �򵥵�˵������������ɢ���롣
		 * ��ϢժҪ�ǰ�ȫ�ĵ����ϣ�����������������С�����ݣ�����̶����ȵĹ�ϣֵ��
		 * 
		 * ����һ������һ����ֵ��Ҳ����java�ļ�����
		 */
		try {
			//��ȡ��������󣬳�����
			MessageDigest mDigest=MessageDigest.getInstance("MD5");
			//ʹ��ָ���� byte �����ժҪ���������£�Ȼ�����ժҪ����
			//�������ݶ�󣬶�����128λ��16���ֽ�
			byte[] bs=mDigest.digest(token.getBytes());
			/*
			 * ���ֱ��new���ַ��������룬��Ϊ��Щ�ֽ�������ģ�ʹ��new String(bs)Ĭ�ϲ�gb2312
			 * �õ����Ǹ�������byte���飬�п���ĳЩbyte�ǲ��ɴ�ӡ���ַ���
                              ������Base64.encode����ת���ɿɴ�ӡ�ַ���
                  base64:
                  ����Java PersistenceϵͳHibernate�У��Ͳ�����Base64����һ���ϳ���Ψһ��ʶ��(һ��Ϊ128-bit��UUID)����Ϊһ���ַ�����
                  ����HTTP����HTTP GET URL�еĲ�����������Ӧ�ó����У�
                  Ҳ������Ҫ�Ѷ��������ݱ���Ϊ�ʺϷ���URL(�������ر���)�е���ʽ����ʱ������Base64������в��ɶ��ԣ�
                  ������������ݲ��ᱻ����������ֱ�ӿ�����
                  Base64Ҫ���ÿ����8Bit���ֽ�ת��Ϊ�ĸ�6Bit���ֽڣ�3*8 = 4*6 = 24����Ȼ���6Bit������λ��λ0������ĸ�8Bit���ֽڣ�
                  Ҳ����˵��ת������ַ��������Ͻ�Ҫ��ԭ���ĳ�1/3��ÿһ���ֽ���С0��00000000�������63��00111111��
			������64��base64��������0-63���ֶ�Ӧ���ַ�����Щ�ַ����Ǽ������ܿ����ģ���������
			
			base64Ӧ�ã�
			���紫�����ݱ����Ӱ������ǰ�лᷢһ����ʼ��־��������һ��������־��ʹ��base64������ת��
			�󣬻�ѡһ����ʼ�ͽ�����ǣ������������base64�������û�У��Ӷ��������ݵĹ����в��ᣬ��Щ����
			����һ��û�н�����ǣ���Щ���ݶ���base64���ģ�������㲻���ж�
			 */
			BASE64Encoder encoder=new BASE64Encoder();
			return encoder.encode(bs);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		return token;
	}
}
