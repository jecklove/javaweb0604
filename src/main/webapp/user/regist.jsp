<%@page import="org.jgs1905.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<link href="${ bp }/static/css/main.css" rel="stylesheet">
</head>
<body>
	
	<div id="pageContent">
		<h3>注册页面</h3>
		<form action="${ bp }/user?method=regist" method="post">
			<p>真实姓名：<input type="text" name="real_name" value="${ user.real_name }"></p>
			<p>用户名：<input type="text" name="username" value="${ user.username }"></p>
			<p>密码：<input type="password" name="password" value="${ user.password }"></p>
			<p><input type="submit" value="注册"></p>
			<p><a href="${ bp }/user/login.jsp">已有账号？立即登录！</a></p>
			<p style="color:red;">${ message }</p>
		</form>
	</div>

</body>
</html>