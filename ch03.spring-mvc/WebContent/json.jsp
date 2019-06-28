<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			$("#putAndGetJson").click(function() {
				//发出一个请求，请头中携带json格式数据
				$.ajax({
					url : "json/test1.action",
					data : '{"userName":"jack","userPass":"123456"}',
					contentType : "application/json",
					type : "post",
					success : function(data) { // data:服务端返回的数据
						alert(JSON.stringify(data));
					},
					dataType : "json"
				});
			});

		});
	</script>
	<input type="button" id="putAndGetJson" value="传输和获取json数据">
</body>
</html>