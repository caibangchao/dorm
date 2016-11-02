<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员页面</title>
<style>
.center {
	position: absolute;
	width: 250px;
	height: 300px;
	left: 40%;
	top: 20%;
	margin: -60px 0px 0px -60px;
}

</style>
<style type="text/css">    
 body{    
      background-image: url(images/home.jpg);    
      background-repeat: repeat-y;    
 }    
 </style>   
</head>
<body>
<div class="center">
<h1>欢迎来到管理员页面&nbsp &nbsp &nbsp <a href='/dorm/home.jsp'>退出</a></h1>
<a href='usercontrol.jsp'>用户操作中心</a></br>
<a href='dorm.jsp'>宿舍信息中心</a></br>

<a href='student.jsp'>学生信息中心</a></br>
<a href='damage.jsp'>宿舍损坏情况登记</a></br>
<a href='visitor.jsp'>访客记录情况登记</a></br>
<a href='score.jsp'>宿舍评分登记查询中心</a></br>



</div>

</body>
</html>