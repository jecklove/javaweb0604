<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加学生页面</title>
<link href="${ bp }/static/css/main.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div id="pageContent">
		<form action="${ bp }/student?method=add" method="post">
			<p>姓名：<input type="text" name="name" value="${ param.name }"></p>
			<p>性别：<input type="text" name="sex"  value="${ param.sex }"></p>
			<p>年龄：<input type="number" name="age" value="${ param.age }"></p>
			<p><input type="submit" value="保存"></p>
			<p style="color: red;">${ param.message }</p>
		</form>
	</div>

</body>
</html>