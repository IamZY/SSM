<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>文件上传</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="${pageContext.request.contextPath }/upload/test1.action" method="post" enctype="multipart/form-data">
  	用户名：<input type="text" name="userName"/><br/>
  	密码：<input type="password" name="userPass"/><br/>
  	头像:<input type="file" name="headIcon"/><br/>
  	<input type="submit" value="保存"/>
  </form>
  </body>
</html>
