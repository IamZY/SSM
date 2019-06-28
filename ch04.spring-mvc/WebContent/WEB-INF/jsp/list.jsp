<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>客户展示</title>
    
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
  <h3>客户所有数据</h3>
  <a href="${pageContext.request.contextPath}/customer/saveUI.action">添加客户</a>
  <form action="${pageContext.request.contextPath}/customer.action" method="post">
  	<input type="hidden" name="_method" value="delete"/>
  <table border="1" width="400px;">
   <tr>
   		<th>选择</th>
   		<th>客户名称</th>
   		<th>客户电话</th>
   		<th>操作</th>
   </tr>
   <c:forEach items="${list}" var="cust">
   <tr>
   		<td><input type="checkbox" name="custIds" value="${cust.custId}"/></td>
   		<td>${cust.custName }</td>
   		<td>${cust.custTelephone }</td>
   		<td><a href="${pageContext.request.contextPath}/customer/${cust.custId}.action">修改</a></td>
   </tr>
   </c:forEach>
  </table>
   <input type="submit" value="删除"/>
  </form>
  
  
  </body>
</html>
