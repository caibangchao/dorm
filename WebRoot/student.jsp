<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息页面</title>
<style>
	form{
		width:50%
		}
	.form1{
		float:left;
	}
	.form2{
		float:left;
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
<h1>欢迎来到学生页面，选择你要的功能</h1>
<h3 style="color:red;">${requestScope.msg }</h3>
<form action="/dorm/addstudent" method="post" class="form1">
<h3>学生信息录入功能</h3>
<table>
<tr>
<td>输入录入学生姓名</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>选择学生性别</td>
<td><select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                    </select>
                    </td>
</tr>
<tr>
<td>输入录入学生生日</td>
<td><input type="text" name="birthday"/></td>
</tr>
<tr>
<td>输入录入学生qq</td>
<td><input type="text" name="qq"/></td>
</tr>
<tr>
<td>输入录入学生电话</td>
<td><input type="text" name="phone"/></td>
</tr>
<tr>
<td>输入录入学生所属班级ID</td>
<td><input type="text" name="class_id"/></td>
</tr>
<tr>
<td>输入录入学生所属宿舍ID</td>
<td><input type="text" name="dorm_id"/></td>
</tr>
<tr><td>
<input type="submit" value="提交">
</td>
<td>
<input type="reset" value="重置">
</td>
</tr>
</table>
</form>
<form action="/dorm/updstudent" method="post" class="form2">
<h3>学生信息修改功能</h3>
<table>
<tr>
<td>输入修改学生姓名</td>
<td><input type="text" name="name"/></td>
</tr>
<tr>
<td>选择学生性别</td>
<td><select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                    </select>
                    </td>
</tr>
<tr>
<td>输入录入学生生日</td>
<td><input type="text" name="birthday"/></td>
</tr>
<tr>
<td>输入录入学生qq</td>
<td><input type="text" name="qq"/></td>
</tr>
<tr>
<td>输入录入学生电话</td>
<td><input type="text" name="phone"/></td>
</tr>
<tr>
<td>输入录入学生所属班级ID</td>
<td><input type="text" name="class_id"/></td>
</tr>
<tr>
<td>输入录入学生所属宿舍ID</td>
<td><input type="text" name="dorm_id"/></td>
</tr>
<tr><td>
<input type="submit" value="提交">
</td>
<td>
<input type="reset" value="重置">
</td>
</tr>
</table>
</form>
</form>
<form action="/dorm/findstudent" method="post">
<h3>学生信息查询功能</h3>
请输入学生名<input type="text" name="name"/> <input
			type="submit" value="确定"/>
</form>
<form action="/dorm/deletestudent" method="post">
<h3>学生信息删除功能</h3>
请输入学生名<input type="text" name="name"/> <input
			type="submit" value="确定"/>
</form>
<h3><a href='/dorm/findallstudent'>查看所有用户信息</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href='/dorm/admin.jsp'>返回上一菜单</a></h3>
</body>
</html>