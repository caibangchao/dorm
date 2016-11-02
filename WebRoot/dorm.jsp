<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>宿舍信息管理界面</title>
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
	<h1>请选择你要进行的操作 &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a href='/dorm/admin.jsp'>返回上一菜单</a></h1>
	<h3 style="color:red;">${requestScope.msg }</h3>
	<form action="adddorm" method="post" class="form1">
	<h3>宿舍录入</h3>
		<table>
			<tr>
				<td>输入宿舍ID</td>
				<td><input type="text" name="id">
				</td>
			</tr>
			<tr>
				<td>输入宿舍名称</td>
				<td><input type="text" name="name">
				</td>
			</tr>
			<tr>
				<td>总床位为</td>
				<td><input type="text" name="bedsum">
				</td>
			</tr>
			<tr>
				<td>已住人数</td>
				<td><input type="text" name="usedbed">
				</td>
			</tr>
			<tr>
				<td>宿舍管理员</td>
				<td><input type="text" name="houseparent">
				</td>
			</tr>
			<tr>
				<td>备注信息</td>
				<td><textarea name="remarks" cols="40" rows="3"></textarea>
				</td>
			</tr>
			<tr>
				<td cosplan='2'><input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
	
	<form action="updatedorm" method="post" class="form2">
	<h3>宿舍修改</h3>
		<table>
			<tr>
				<td>输入要修改宿舍ID</td>
				<td><input type="text" name="id1">
				</td>
			</tr>
			<tr>
				<td>宿舍名称</td>
				<td><input type="text" name="name1">
				</td>
			</tr>
            <tr>
				<td>总床位为</td>
				<td><input type="text" name="bedsum1">
				</td>
			</tr>
			<tr>
				<td>已住人数</td>
				<td><input type="text" name="usedbed1">
				</td>
			</tr>
			<tr>
				<td>宿舍管理员</td>
				<td><input type="text" name="houseparent1">
				</td>
			</tr>
			<tr>
				<td>备注信息</td>
				<td><textarea name="remarks1" cols="40" rows="3"></textarea>
				</td>
			</tr>
			<tr>
				<td cosplan='2'><input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
	
	<form action="finddorm" method="post">
	<h3>宿舍查询</h3>
		<table>
			<tr>
				<td>输入要查询宿舍ID</td>
				<td><input type="text" name="id2">
				</td>
			</tr>
			<tr>
				<td cosplan='2'><input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
	
	<form action="deletedorm" method="post">
	<h3>宿舍删除</h3>
		<table>
			<tr>
				<td>输入要删除宿舍ID</td>
				<td><input type="text" name="id3">
				</td>
			</tr>
			<tr>
				<td cosplan='2'><input type="submit" value="提交">
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>