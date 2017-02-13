<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserAction" method="post">
		<input type="hidden" name="flag" value="doAdd"/>
		姓名<input type="text" name="studentname"/>
		班级<input type="text" name="calss_id"/>
		<input type="submit" value="新增"/>
	</form>
</body>
</html>