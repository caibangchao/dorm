<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>访客信息登记</title>
<style type="text/css">    
 body{    
      background-image: url(images/home.jpg);    
      background-repeat: repeat-y;    
 }    
 </style> 
<style>
.center {
	position: absolute;
	width: 400px;
	height: 300px;
	left: 40%;
	top: 30%;
	margin: -60px 0px 0px -60px;
}
</style>
</head>
<body>
<div class="center">
<h1>访客信息登记与查询</h1>
<h3 style="color:red;">${requestScope.msg }</h3>
<form action="/dorm/addvisitor" method="post">
<h1>访客信息登记</h1>
<table>
<tr>
<td>访客姓名</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>访客地址</td>
<td><input type="text" name="address"></td>
</tr>
<tr>
<td>访客与被访问人关系</td>
<td><input type="text" name="relation"></td>
</tr>
<tr>
<td>被访问学生姓名</td>
<td><input type="text" name="student_name"></td>
</tr>
<tr>
<td>学生宿舍ID</td>
<td><input type="text" name="dorm_id"></td>
</tr>
<tr>
<td cosplan='2'><input type="submit" value="提交"></td>

</tr>
</table>
</form>
<h3><a href='/dorm/findallvisitor'>查看所有访客信息</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href='/dorm/admin.jsp'>返回上一菜单</a></h3>
</div>
</body>
</html>