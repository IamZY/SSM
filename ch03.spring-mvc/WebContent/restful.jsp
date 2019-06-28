<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>对restful支持</title>
    
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
  <h3>查询操作</h3>
  <form action="${pageContext.request.contextPath}/restful.action" method="get">
  	<input type="submit" value="提交"/>
  </form>
  
  <hr/>
  
  <h3>新增操作</h3>
  <form action="${pageContext.request.contextPath}/restful.action" method="post">
  	用户名：<input type="text" name="userName"/><br/>
  	密码：<input type="password" name="userPass"/><br/>
  	<input type="submit" value="提交"/>
  </form>
  
   <h3>更新操作</h3>
  <form action="${pageContext.request.contextPath}/restful.action" method="post">
  	<input type="hidden" name="_method" value="put">
  	<input type="hidden" name="userId" value="1">
  	用户名：<input type="text" name="userName"/><br/>
  	密码：<input type="password" name="userPass"/><br/>
  	<input type="submit" value="提交"/>
  </form>
  
  <h3>删除操作</h3>
  <form action="${pageContext.request.contextPath}/restful/1.action" method="post">
  	<input type="hidden" name="_method" value="delete">
  	<input type="submit" value="提交"/>
  </form>
  </body>
</html>
