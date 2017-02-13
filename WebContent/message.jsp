<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<center>
 		<table >
 			<tr>
 				<td>编号</td>
 				<td>姓名</td>
 				<td>班级</td>
 				<td>操作</td>
 			</tr>
 			<c:forEach items="${list}" var="u">
 				<tr>
 					<td>${u.studentid}</td>
 					<td>${u.studentname}</td>
 					<td>${u.classname}</td>
 					<td><a href="UserAction?flag=toupdate&studentid=${u.studentid}" >修改</a>
 					<a href="UserAction?flag=delete&studentid=${u.studentid}" >删除</a></td>
 				</tr>
 			</c:forEach>
 			</table>
 			<a href="add.jsp">新增用户</a><br>
 			<form action="UserAction">
 				<input type="hidden" name="flag" value="page"/>
 				查找第<input type="text" name="page" />页 
 				<input type="submit" value="开始查找" />
 				<a href="UserAction" >显示全部</a>(一共有${count}个人)
 			</form>
 			<a href="UserAction?flag=jump1">首页</a>
 			<a href="UserAction?flag=jump${pagelast}">上一页</a>
 			${bar}
 			<a href="UserAction?flag=jump${pagenext}">下一页</a>
 			<a href="UserAction?flag=jump${pagenum}">尾页</a>
 	</center>
</body>
</html>