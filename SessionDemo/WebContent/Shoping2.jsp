<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
如果浏览器禁用了cookie也就是发送cookie的时候浏览器不接收，那么就不能根据cookieID找到session，还是不能获取
购买的商品信息。访问服务器都是通过超链接访问，如果不以cookie形式发送ID号，那么可以通过点击超链接的时候让
超链接带ID号过来，也就是当用户访问首页的时候，为每个用户浏览器创建session会话，通过response的encodeURL()
方法在每个超链接的后面加上session的ID号，访问到超链接的服务器后，获取ID，找到session
 -->
 <%
 request.getSession();
 String url1=response.encodeURL("/SessionDemo/buy");
 String url2=response.encodeURL("/SessionDemo/pay");
 System.out.println(url1);
 %>
<a href=url1>购买洗衣机</a><br>
<a href=url2>查看购买商品</a>
</body>
</html>