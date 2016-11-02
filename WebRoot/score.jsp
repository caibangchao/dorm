<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">    
 body{    
      background-image: url(images/home.jpg);    
      background-repeat: repeat-y;    
 }    
 </style>  
</head>
<body>
<h1>又是一周宿舍评分大比</h1>
<h3 style="color:red;">${requestScope.msg }</h3>
<form action="/dorm/addscore" method="post" >
	<h3>宿舍分数录入,每项分数占25分</h3>
		<table>
			<tr>
				<td>输入宿舍ID</td>
				<td><input type="text" name="dorm_id"></td>
			</tr>
			<tr>
				<td>宿舍整齐度打分</td>
				<td><input type="text" name="neat"></td>
			</tr>
			<tr>
				<td>宿舍干净度打分</td>
				<td><input type="text" name="clear"></td>
			</tr>
			<tr>
				<td>宿舍异味度打分</td>
				<td><input type="text" name="smell"></td>
			</tr>
			<tr>
				<td>宿舍纪律度打分</td>
				<td><input type="text" name="discipline"></td>
			</tr>
			<tr>
				<td>本次该寝室所获总分</td>
				<td><input type="text" name="score_sum"></td>
			</tr>
			<tr>
				<td cosplan='2'><input type="submit" value="提交">
				</td>
			</tr>
         </table>
</form>

<h3><a href='/dorm/findallscore'>查询所有寝室总成绩(由低到高)</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href='/dorm/deleteall'>清空本次记录开始下次评分</a></h3>
<h2><a href='/dorm/admin.jsp'>返回上一菜单</a></h2>

</body>
</html>