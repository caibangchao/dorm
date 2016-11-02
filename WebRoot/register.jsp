<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<style type="text/css" media="screen">
.center {
	position: absolute;
	width: 400px;
	height: 400px;
	left: 45%;
	top: 40%;
	margin: -60px 0px 0px -60px;
}
</style>
<style type="text/css">
body {
	background-image: url(images/home.jpg);
	background-repeat: repeat-y;
}
</style>
<script type="text/javascript">
	function change() {
		//切换验证码
		document.getElementById("myimg").src = "/dormSystem/check?"
				+ new Date().getTime();
	}
</script>
<style type="text/css">    
 body{    
      background-image: url(images/home.jpg);    
      background-repeat: repeat-x;    
 }    
 </style>   
</head>
<body>
	<div class="center">
		<h1>欢迎注册页面</h1>
		<h3 style="color:red;">${requestScope.msg }</h3>
		<form action="/dorm/register" method="post">
			<table>
				<tr>
					<td>请输入用户名</td>
					<td><input type="text" name="username">
					</td>
				</tr>
				<tr>
					<td>请输入密码</td>
					<td><input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td>请确认密码</td>
					<td><input type="password" name="password1">
					</td>
				</tr>
				<tr>
					<td>请输入您的邮箱</td>
					<td><input type="text" name="email">
					</td>
				</tr>
				<tr>
					<td>请输入验证码</td>
					<td><input type="text" name="checkcode" /><img id="myimg"
						src="/dorm/check" style="cursor:pointer; "
						onclick="change();" /><br />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="提交" />
					</td>
					<td><input type="reset" value="重置" />
					</td>
				</tr>
			</table>
		</form>
		<h2><a href='/dorm/home.jsp'>返回主页面</a></h2>
	</div>
</body>
</html>