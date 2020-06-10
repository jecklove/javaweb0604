<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎页</title>
</head>
<body>
	<!-- jsp动作标签：转发标签 -->
	<jsp:forward page="main.jsp"></jsp:forward>
</body>
</html>