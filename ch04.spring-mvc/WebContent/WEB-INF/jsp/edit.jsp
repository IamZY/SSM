<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户修改页面</title>
    
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
  
  <form action="${pageContext.request.contextPath}/customer.action" method="post">
  	<input type="hidden" name="_method" value="put"/>
  	<input type="hidden" name="custId" value="${cust.custId}">
  	客户名称：<input type="text" name="custName" value="${cust.custName}"/><br/>
  	客户电话：<input type="text" name="custTelephone" value="${cust.custTelephone }"/><br/>
  	<input type="submit" value="修改">
  </form>
  
  </body>
</html>
