<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function regist() {
		// 如果需要在新窗口打开注册界面；
		// window.open('Untitled-2.html');
		// 如果需要在当前窗口打开登录界面
		window.location.href = 'register.jsp';
	}
</script>

<title>首页</title>
<style>
.center {
	position: absolute;
	width: 250px;
	height: 300px;
	left: 50%;
	top: 50%;
	margin: -60px 0px 0px -60px;
}
</style>
 <style type="text/css">    
 body{    
      background-image: url(images/home.jpg);    
      background-repeat: repeat-y;    
 }    
 </style>   
<script type="text/javascript">
	function change() {
		//切换验证码
		document.getElementById("myimg").src = "/dorm/check?"
				+ new Date().getTime();
	}
</script>
</head>
<body>
	
	
	<div class="center">
		<h3 style="color:red;">${requestScope.msg }</h3>
		<h2>欢迎进入大学生宿舍管理系统</h2>
		<form action="/dorm/login" method="post">

			<table>
				<tr>
					<td>用户名</td>
					<td><input type="text" name="username" />
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" name="password" />
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
					<td><input type="submit" value="登录" name="denglu" />
					</td>
					<td><input type="button" value="注册" name="zhuce" id="bt"
						onclick="regist()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>