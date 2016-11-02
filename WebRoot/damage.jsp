<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宿舍管理界面</title>
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
<h1>宿舍损坏情况明细</h1>
<h3 style="color:red;">${requestScope.msg }</h3>
<form action="/dorm/adddamage" method="post" class="form1">
<h2>损坏情况登记</h2>
<table>
<tr>
<td>损坏宿舍ID</td>
<td><input type="text" name="dorm_id"/></td>
</tr>
<tr>
<td>损坏哪里</td>
<td><input type="text" name="question"/></td>
</tr>
<tr>
<td>损坏时间</td>
<td><input type="text" name="st_date"/></td>
</tr>
<tr>
				<td>备注信息</td>
				<td><textarea name="remarks" cols="40" rows="3"></textarea>
				</td>
			</tr>
<tr>
<td cosplan='2'><input type="submit" value="提交"/></td>
</tr>
</table>
</form>

<form action="/dorm/updatedamage" method="post" class="form2">
<h2>修补情况登记</h2>
<table>
<tr>
<td>损坏宿舍ID</td>
<td><input type="text" name="dorm_id"/></td>
</tr>
<tr>
<td>修补时间</td>
<td><input type="text" name="fi_date"/></td>

<tr>
<td>选择修复情况</td>
<td><select name="isok">
                    <option value="成功">成功</option>
                    <option value="未修复">未修复</option>
                    </select>
                    </td>
</tr>
</tr>
<tr>
				<td>备注信息</td>
				<td><textarea name="remarks" cols="40" rows="3"></textarea>
				</td>
			</tr>
<tr>
<td cosplan='2'><input type="submit" value="确定"/></td>
</tr>
</table>
</form>
<h3><a href='/dorm/findalldamage'>查看所有损坏信息</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href='/dorm/admin.jsp'>返回上一菜单</a></h3>

</body>
</html>