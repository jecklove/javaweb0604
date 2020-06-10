<%@page import="java.net.URLDecoder"%>
<%@page import="org.jgs1905.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link href="${ bp }/static/css/main.css" rel="stylesheet">
</head>
<body>
	<div id="pageContent">
		<h3>登录页面</h3>
		<form action="${ bp }/user?method=login" method="post">
			<p>用户名：<input type="text" name="username" value="${ user ne null ? user.username : cookie.username.value}"></p>
			<p>密码：<input type="password" name="password" value="${ cookie.password.value }"></p>
			<p><input type="checkbox" name="rememberMe" value="rememberMe" ${ cookie.rememberMe.value eq "rememberMe" ? "checked" : "" }>记住我</p>
			<p><input type="submit" value="登录"></p>
			<p><a href="${ bp }/user/regist.jsp">没有账号？立即注册！</a></p>
			
			<p style="color:red;">${ message }</p>
		</form>
	</div>
	<%
		session.removeAttribute("message");
	%>
</body>
</html>