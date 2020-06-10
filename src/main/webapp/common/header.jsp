<%@page import="org.jgs1905.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公共头部代码</title>
<style type="text/css">
	#header {
		width: 800px;
		height: 60px;
		border: 1px solid green;
		margin: 0 auto;
		padding: 0 50px;
		box-sizing: border-box;
		position: relative;
		
		font-size: 30px;
		line-height: 60px;
	}
	
	#logoutBtn,#loginBtn {
		position: absolute;
		right: 50px;
	}
	
</style>
</head>
<body>
	
	<div id="header">
		<c:if test="${ onlineUser ne null }">
			<span>${ onlineUser.real_name }，欢迎您！</span>
			<span id="logoutBtn"><a href="${ bp }/user?method=logout">退出登录</a></span>
		</c:if>
		<c:if test="${ onlineUser eq null }">
			<span>登陆后可进行数据修改操作！</span>
			<span id="loginBtn"><a href="${ bp }/user/login.jsp">立即登录</a></span>
		</c:if>
	</div>

</body>
</html>