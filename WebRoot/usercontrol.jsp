<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理界面</title>
<style type="text/css" media="screen">
.center {
	position: absolute;
	width: 500px;
	height: 100%;
	left: 50%;
	top: 10%;
	margin: -60px 0px 0px -60px;
}
</style>
<style type="text/css">
body {
	background-image: url(images/home.jpg);
	background-repeat: repeat-y;
}
</style>
<style type="text/css">    
 body{    
      background-image: url(images/home.jpg);    
      background-repeat: repeat-x;    
 }    
 </style>   
</head>
<body>
<div class="center">
	<h1 style="color:white">选择你要进行的操作</h1>
	<h3 style="color:red;">${msg }</h3>
	<h2>查看用户信息:输入用户名进行查找用户操作</h2>
	<form action="/dorm/finduser" method="post">
		请输入用户名：<input type="text" name="username1"> <input
			type="submit" value="确定">
	</form>
	<h2>删除用户信息:输入用户id进行删除用户操作</h2>
	<form action="/dorm/deleteuser" method="post">
		请输入id：<input type="text" name="id"> <input
			type="submit" value="确定">
	</form>
	<h2>增加用户信息，与注册功能相同</h2>
	<form action="/dorm/adduser" method="post">
	<table>
		<tr>
			<td>输入用户名</td>
			<td><input type="text" name="username3" />
			</td>
		</tr>
		<tr>
			<td>输入密码</td>
			<td><input type="password" name="pwd" />
			<br></td>
		</tr>
		<tr>
			<td>输入邮箱</td>
			<td><input type="text" name="email" />
			</td><td><input type="submit" value="提交">
			</td>
		</tr>
		
		</table>
	</form>
	<h2>请输入您要修改的用户id和用户内容</h2>
	<form action="/dorm/updateuser" method="post">
	<table>
		<tr>
			<td>输入id</td>
			<td><input type="text" name="id1" /><br>
			</td><td>输入用户名</td>
			<td><input type="text" name="username4" /><br>
			</td>
		</tr>
		
		<tr>
			<td>输入密码</td>
			<td><input type="password" name="pwd1" /><br>
			</td><td>输入邮箱</td>
			<td><input type="text" name="email1" /><br>
			</td>
		</tr>
		
		<tr>
			<td cosplan='2'><input type="submit" value="提交">
			</td>
		</tr>
		</table>
	</form>
	<h3><a href='/dorm/findalluser'>查看所有用户信息</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href='/dorm/admin.jsp'>返回上一菜单</a></h3>
	</div>
</body>
</html>