<%@page import="org.jgs1905.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="org.jgs1905.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="bp" value="${ pageContext.request.contextPath }" scope="application" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生列表页</title>
<link href="${ bp }/static/css/main.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../common/header.jsp" %>

	<div id="pageContent">
		<a href="${ bp }/student/add.jsp">添加学生</a>
		
		<c:if test="${ empty students }">
			<p align="center">暂无数据</p>
		</c:if>
		
		<c:if test="${ !empty students }">
			<table width="100%" align="center" border="1" cellspacing="0">
				<tr>
					<th>序号</th>
					<th>学号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>操作</th>
				</tr>
	
				<c:forEach items="${ students }" var="student" varStatus="vs">
				
					<tr align="center">
						<td>${ vs.count }</td>
						<td>${ student.id }</td>
						<td>${ student.name }</td>
						<td>${ student.sex }</td>
						<td>${ student.age }</td>
						<td>
							<button class="deleteBtn" data-id="${ student.id }">删除</button>
							<button class="updateBtn" data-id="${ student.id }">修改</button>
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		</c:if>
		
	</div>

	<script src="${ bp }/static/js/jquery-3.5.1.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(function() {
			$('.deleteBtn').click(function() {
				if (confirm('你确定要删除吗？')) {
					let id = $(this).data('id');
					console.log(id);
					location.href = "${bp}/student?method=delete&id=" + id;
				}				
			});
			
			$('.updateBtn').click(function() {
				let id = $(this).data('id');
				console.log(id);
				location.href = "${bp}/student?method=update&id=" + id;
			});
		})
	</script>
</body>
</html>