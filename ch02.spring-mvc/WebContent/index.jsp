<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<h3>1.默认参数类型</h3>
	<form action="${pageContext.request.contextPath}/param/test1.action"
		method="post">
		用户名：<input type="text" name="userName" /><br /> 密码：<input
			type="password" name="userPass" /><br /> <input type="submit"
			value="提交" />
	</form>

	<hr />

	<h3>2.@PathVariable路径参数接收</h3>
	<form
		action="${pageContext.request.contextPath}/param/test2/zhangsan/123456.action"
		method="post">
		<input type="submit" value="提交" />
	</form>

	<hr />

	<h3>3.简单数据类型</h3>
	<form action="${pageContext.request.contextPath}/param/test3.action"
		method="post">
		用户名：<input type="text" name="name" /><br /> 密码：<input
			type="password" name="userPass" /><br /> <input type="submit"
			value="提交" />
	</form>

	<hr />

	<h3>4.JavaBean类型</h3>
	<form action="${pageContext.request.contextPath}/param/test4.action"
		method="post">
		用户名：<input type="text" name="userName" /><br /> 密码：<input
			type="password" name="userPass" /><br /> 手机：<input type="text"
			name="userTelephone" /><br /> <input type="submit" value="提交" />
	</form>

	<h3>5.包装JavaBean类型</h3>
	<form action="${pageContext.request.contextPath}/param/test5.action"
		method="post">
		用户名：<input type="text" name="user.userName" /><br /> 密码：<input
			type="password" name="user.userPass" /><br /> 手机：<input type="text"
			name="user.userTelephone" /><br /> 性别： <input type="radio"
			name="gender" value="男" />男 <input type="radio" name="gender"
			value="女" />女 <input type="submit" value="提交" />
	</form>

	<h3>6.绑定数组类型</h3>
	<form action="${pageContext.request.contextPath}/param/test6.action"
		method="post">
		<input type="checkbox" name="custId" value="1" />数据1<br /> <input
			type="checkbox" name="custId" value="2" />数据2<br /> <input
			type="checkbox" name="custId" value="3" />数据3<br /> <input
			type="submit" value="删除" />
	</form>

	<h3>7.自定义参数类型转换</h3>
	<form action="${pageContext.request.contextPath}/param/test7.action"
		method="post">
		生日：<input type="text" name="birth" /><br /> <input type="submit"
			value="提交" />
	</form>

</body>
</html>