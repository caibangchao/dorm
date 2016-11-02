<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录查询页面</title>

<style type="text/css">
body {
	background-image: url(images/home.jpg);
	background-repeat: repeat-y;
}
</style>
<style>
.center {
	position: absolute;
	width: 400px;
	height: 400px;
	left: 50%;
	top: 20%;
	margin: -60px 0px 0px -60px;
}
</style>
</head>
<body>
	<div class="center">
		<h1>欢迎来到宿舍用户查询页面，请选择你要查看的选项</h1>
		<h3 style="color:red;">${requestScope.msg }</h3>
		<h2>
			<a href="/dorm/findallscore1">本周宿舍评分汇总</a>
		</h2>
		<h2>
			<a href='/dorm/findallvisitor1'>查看所有访客信息</a>
		</h2>
		<form action="/dorm/findstudent1" method="post">
			<h3>学生信息查询功能</h3>
			请输入学生名<input type="text" name="name" /> <input type="submit"
				value="确定" />
		</form>
		<form action="finddorm1" method="post">
			<h3>宿舍信息查询</h3>
			<table>
				<tr>
					<td>输入要查询宿舍ID</td>
					<td><input type="text" name="id2"></td>
				</tr>
				<tr>
					<td cosplan='2'><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
		<h2>
		<a href='/dorm/home.jsp'>退出</a>
	</h2>
	</div>
	

</body>
</html>