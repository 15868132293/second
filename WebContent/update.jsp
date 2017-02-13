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
 	<form action="UserAction" method="post">
		<input type="hidden" name="flag" value="doupdate"/>
		<input type="hidden" name="studentid" value="${list[0].studentid}"/>
		学生姓名<input type="text" name="studentname" value="${list[0].studentname}"/>
		班级ID<input type="text" name="classid" value="${list[0].class_id}"/>
		<input type="submit" value="更新"/>
	</form>
</body>
</html>