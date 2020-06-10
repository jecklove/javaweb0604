<%@page import="org.jgs1905.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>平台主页</title>
<link href="${ bp }/static/css/main.css" rel="stylesheet">
</head>
<body>
	
	<%@ include file="common/header.jsp" %>
	
	<div id="pageContent">
		<h1>平台主页</h1>
		<h3><a href="${ bp }/student?method=list">学生信息管理</a></h3>
	</div>
	
</body>
</html>