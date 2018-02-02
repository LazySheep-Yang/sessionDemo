<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
var checkSub=false;
//方法1：通过标记
function check() {
	
	
	if(!checkSub){//第一次点击提交，可以提交
		checkSub=true;//第一次点击了就置为true
		return true;
	}
	else{
		return false;
	}
	
	
}

//方法2：通过改变submit按钮的可点击性
function check2() {
	
	//通过id得到这个按钮
	var button=document.getElementById("submit");
	//设置按钮不可点击
	button.disabled="disabled";
	
	//第一次提交一次
	return true;
}

</script>
<body>
<!-- 
防表单重复提交:
当有网络延迟的时候，用户认为当前提交没有效果，所有一直点击提交按钮

方法1：在js的代码里控制，通过表单的onSubmit属性：
但是这个方法有严重问题，当用户在浏览器点击查看源码的时候，发现这个是用js控制的，于是他便可以修改
或者通过刷新页面重复提交
onsubmit 属性指定了一个事件句柄函数。当用户单击了表单中的 Submit 按钮而提交一个表单时，就会调用这个事件句柄函数。
如果 onsubmit 句柄返回 fasle，表单的元素就不会提交。如果该函数返回其他值或什么都没有返回，则表单会被提交。
这一特性使得该事件句柄函数适用于做表单提交前的验证。

方法2：先通过服务器获得一个随机数id号，把这个id号发给表单form，同时把id存入服务器即存入session，当表单
提交到某个服务器的时候，这个服务器通过getSession获取到session，通过session获取到存入的id，若表单
传过来的id是空则代表没有通过服务器发送id的形式打开表单，不提交。若id与服务器存入的id相同，则认为可以提交，提交
完毕立即将服务器session的id删除，若id与服务器的id不同（即第一次提交完id被删除），则认为是重复提交
 -->
 <!-- <form action="/SessionDemo/submit" method="post" onsubmit="return check2()">
 <input type="text" name="username"><br>
 <input id="submit" name="submit" value="注册" type="submit">
 </form> -->
 
 
 
 <form action="/SessionDemo/submit" method="post" >
 <!-- 
 隐藏属性，以后看不到,可以通过查看源码，注意要先访问severlet
  -->
 <input type="hidden" name="hidden" value="${id}">
 用户名:<input type="text" name="username"><br>
 <input id="submit" name="submit" value="注册" type="submit">
 </form>
</body>
</html>