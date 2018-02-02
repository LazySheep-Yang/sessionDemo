package com.lvyang.ReSubmit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

//出于随机数出现相同概率的考虑，将此类写成单利模式。使一个对象生成相同的随机数概率降低
public class TokenProcessor {//令牌

	private static final TokenProcessor r=new TokenProcessor();
	private TokenProcessor(){
		
	}
	public static TokenProcessor getInstance() {
			return r;
	}
	
	
	//生成随机的字符串
	public String generalToken() {
		//根据当前时间加一个随机数的形式
		String token=System.currentTimeMillis()+new Random().nextInt()+"";
		
		/*得到数据摘要，每个数据都有一个指纹（摘要），长度一样
		 * 上述得到的随机数字符长度可能不一样，使用MessageDigest类
		 * 用于为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
		 * 简单点说就是用于生成散列码。
		 * 信息摘要是安全的单向哈希函数，它接收任意大小的数据，输出固定长度的哈希值。
		 * 
		 * 返回一个长度一样的值，也就是java的加密类
		 */
		try {
			//获取到这个对象，抽象类
			MessageDigest mDigest=MessageDigest.getInstance("MD5");
			//使用指定的 byte 数组对摘要进行最后更新，然后完成摘要计算
			//不论数据多大，都返回128位即16个字节
			byte[] bs=mDigest.digest(token.getBytes());
			/*
			 * 如果直接new成字符串会乱码，因为这些字节是任意的，使用new String(bs)默认查gb2312
			 * 得到的是个二进制byte数组，有可能某些byte是不可打印的字符。
                              所以用Base64.encode把它转化成可打印字符。
                  base64:
                  ，在Java Persistence系统Hibernate中，就采用了Base64来将一个较长的唯一标识符(一般为128-bit的UUID)编码为一个字符串，
                  用作HTTP表单和HTTP GET URL中的参数。在其他应用程序中，
                  也常常需要把二进制数据编码为适合放在URL(包括隐藏表单域)中的形式。此时，采用Base64编码具有不可读性，
                  即所编码的数据不会被人用肉眼所直接看到。
                  Base64要求把每三个8Bit的字节转换为四个6Bit的字节（3*8 = 4*6 = 24），然后把6Bit再添两位高位0，组成四个8Bit的字节，
                  也就是说，转换后的字符串理论上将要比原来的长1/3。每一个字节最小0（00000000），最大63（00111111）
			不超过64，base64码表定义出了0-63数字对应的字符，这些字符都是键盘上能看到的，不会乱码
			
			base64应用：
			网络传输数据比如电影：传输前有会发一个开始标志，结束后发一个结束标志，使用base64将数组转码
			后，会选一个开始和结束标记，这两个标记在base64码表里面没有，从而传输数据的过程中不会，这些数据
			里面一定没有结束标记（这些数据都是base64码表的），传输便不会中断
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
