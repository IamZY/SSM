<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<h3>1.1.@ExceptionHandler注解处理异常</h3>
	<a href="${pageContext.request.contextPath}/exception/test1.action">@ExceptionHandler注解处理异常</a>

	<hr />

	<h3>1.2.SimpleMappingExceptionResolver处理异常</h3>
	<a href="${pageContext.request.contextPath}/exception/test2.action">SimpleMappingExceptionResolver处理异常</a>

	<hr />

	<h3>1.3.HandlerExceptionResolver处理异常</h3>
	<a href="${pageContext.request.contextPath}/exception/test3.action">1.3.HandlerExceptionResolver处理异常</a>
</body>
</html>